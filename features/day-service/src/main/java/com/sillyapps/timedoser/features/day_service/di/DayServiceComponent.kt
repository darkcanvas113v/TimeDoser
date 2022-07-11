package com.sillyapps.timedoser.features.day_service.di

import android.content.Intent
import com.sillyapps.core.di.AppScope
import com.sillyapps.core.di.FeatureScope
import com.sillyapps.timedoser.domain.di.DayComponent
import com.sillyapps.timedoser.features.day_service.DayService
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@FeatureScope
@Component(dependencies = [DayComponent::class])
interface DayServiceComponent {

  fun inject(dayService: DayService)

  @Component.Builder
  interface Builder {

    fun dayComponent(dayComponent: DayComponent): Builder

    @BindsInstance
    fun mainActivityIntent(@MainActivityIntent intent: Intent): Builder

    fun build(): DayServiceComponent

  }

}

@Qualifier
annotation class MainActivityIntent