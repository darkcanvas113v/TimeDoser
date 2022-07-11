package com.sillyapps.timedoser.features.day_service.api

import android.content.Intent
import com.sillyapps.timedoser.domain.di.DayComponent
import com.sillyapps.timedoser.features.day_service.di.MainActivityIntent

interface DayServiceApp {

  fun getDayComponent(): DayComponent

  @MainActivityIntent fun getMainActivityIntent(): Intent

}