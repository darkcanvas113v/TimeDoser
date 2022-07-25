package com.sillyapps.timedoser.features.alarm.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.core.di.ScreenScope
import com.sillyapps.timedoser.domain.di.DayComponent
import dagger.Component

@ScreenScope
@Component(dependencies = [DayComponent::class])
interface AlarmScreenComponent {

  @Component.Builder
  interface Builder {

    fun dayComponent(dayComponent: DayComponent): Builder

    fun build(): AlarmScreenComponent

  }

}