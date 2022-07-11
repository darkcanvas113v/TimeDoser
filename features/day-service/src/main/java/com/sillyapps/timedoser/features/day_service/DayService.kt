package com.sillyapps.timedoser.features.day_service

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.sillyapps.core.ui.service.getImmutablePendingIntentFlags
import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.usecases.GetDayUseCase
import com.sillyapps.timedoser.domain.usecases.PauseDayUseCase
import com.sillyapps.timedoser.domain.usecases.StartDayUseCase
import com.sillyapps.timedoser.domain.usecases.StopDayUseCase
import com.sillyapps.timedoser.features.day_service.api.DayServiceApp
import com.sillyapps.timedoser.features.day_service.di.DaggerDayServiceComponent
import com.sillyapps.timedoser.features.day_service.di.DayServiceComponent
import com.sillyapps.timedoser.features.day_service.di.MainActivityIntent
import com.sillyapps.timedoser.features.day_service.model.DayServiceModel
import com.sillyapps.timedoser.features.day_service.model.toDayServiceModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.sillyapps.timedoser.common.ui.R as common_ui_res

class DayService : Service() {

  @Inject
  lateinit var startDayUseCase: StartDayUseCase

  @Inject
  lateinit var pauseDayUseCase: PauseDayUseCase

  @Inject
  lateinit var stopDayUseCase: StopDayUseCase

  @Inject
  lateinit var getDayUseCase: GetDayUseCase

  @Inject
  @MainActivityIntent
  lateinit var mainActivityIntent: Intent

  private val serviceJob = Job()
  private val scope = CoroutineScope(Dispatchers.Main + serviceJob)

  private val model by lazy {
    getDayUseCase().map {
      if (it is DataState.Success) it.data.toDayServiceModel()
      else DayServiceModel.NULL
    }
  }

  private val notificationManager by lazy {
    getSystemService(NOTIFICATION_SERVICE) as NotificationManager
  }

  private val activeNotificationBuilder by lazy {
    getDefaultNotificationBuilder()
      .addAction(
        common_ui_res.drawable.ic_baseline_pause_24, getString(R.string.pause), getPendingIntent(
          ACTION_PAUSE
        )
      )
      .addAction(
        common_ui_res.drawable.ic_baseline_stop_24, getString(R.string.stop), getPendingIntent(
          ACTION_STOP
        )
      )
  }

  private val disabledNotificationBuilder by lazy {
    getDefaultNotificationBuilder()
      .addAction(
        common_ui_res.drawable.ic_baseline_play_arrow_24,
        getString(R.string.start),
        getPendingIntent(
          ACTION_START
        )
      )
  }

  override fun onBind(p0: Intent?): IBinder? {
    return null
  }

  override fun onCreate() {
    super.onCreate()

    val app = (application as DayServiceApp)

    val dayServiceComponent = DaggerDayServiceComponent.builder()
      .dayComponent(app.getDayComponent())
      .mainActivityIntent(app.getMainActivityIntent())
      .build()

    dayServiceComponent.inject(this)

    startForeground(ID, activeNotificationBuilder.build())
    observeDay()
  }

  private fun observeDay() {
    scope.launch {
      model.collect {
        when (it.state) {
          Day.STATE_ACTIVE -> {
            activeNotificationBuilder.setContentTitle(it.currentTaskName)
            activeNotificationBuilder.setContentText(it.timeRemained)
            notificationManager.notify(ID, activeNotificationBuilder.build())
          }

          Day.STATE_DISABLED -> {
            disabledNotificationBuilder.setContentTitle(it.currentTaskName)
            disabledNotificationBuilder.setContentText(it.timeRemained)
            notificationManager.notify(ID, disabledNotificationBuilder.build())
          }

          Day.STATE_COMPLETED, Day.STATE_WAITING -> {
            stopSelf()
          }
        }
      }
    }
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    if (intent == null) return START_NOT_STICKY

    when (intent.action) {
      ACTION_STOP -> {
        scope.launch { stopDayUseCase() }
      }
      ACTION_PAUSE -> {
        scope.launch { pauseDayUseCase() }
      }
      ACTION_START -> {
        scope.launch { startDayUseCase() }
      }
    }

    return START_NOT_STICKY
  }

  private fun getPendingIntent(action: String): PendingIntent {
    val intent = Intent(applicationContext, DayService::class.java)
    intent.action = action
    return PendingIntent.getService(applicationContext, 0, intent, getImmutablePendingIntentFlags())
  }

  override fun onDestroy() {
    super.onDestroy()
    serviceJob.cancel()
  }

  private fun getDefaultNotificationBuilder(): NotificationCompat.Builder {
    return NotificationCompat.Builder(this, DayServiceNotificationChannel.ID)
      .setPriority(NotificationCompat.PRIORITY_DEFAULT)
      .setSmallIcon(common_ui_res.drawable.ic_launcher_foreground)
      .setContentIntent(
        PendingIntent.getActivity(
          this,
          0,
          mainActivityIntent,
          getImmutablePendingIntentFlags()
        )
      )
      .setAutoCancel(false)
      .setOngoing(true)
      .setOnlyAlertOnce(true)
  }

  companion object {
    const val ID = 1
    const val ACTION_STOP = "STOP"
    const val ACTION_START = "START"
    const val ACTION_PAUSE = "PAUSE"
  }

}