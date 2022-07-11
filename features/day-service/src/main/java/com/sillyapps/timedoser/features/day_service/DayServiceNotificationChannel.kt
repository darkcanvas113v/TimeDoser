package com.sillyapps.timedoser.features.day_service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

fun setDayServiceNotificationChannel(context: Context) {

  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    val name = "Day service"
    val descriptionText = "Helps to keep app alive and gives user some control options"
    val importance = NotificationManager.IMPORTANCE_HIGH
    val mChannel = NotificationChannel(DayServiceNotificationChannel.ID, name, importance)
    mChannel.description = descriptionText

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(mChannel)
  }

}

object DayServiceNotificationChannel {
  const val ID = "TIMEDOSER_DAYSERVICE_NOTIFICATION_CHANNEL"
}