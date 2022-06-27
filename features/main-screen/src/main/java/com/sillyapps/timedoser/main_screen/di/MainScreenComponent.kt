package com.sillyapps.timedoser.main_screen.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.core.di.ScreenScope
import com.sillyapps.core_util.ticker.CoroutineTicker
import com.sillyapps.core_util.ticker.Ticker
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.di.DayComponent
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.main_screen.ui.MainScreenViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@ScreenScope
@Component(dependencies = [DayComponent::class])
interface MainScreenComponent {

  fun getViewModel(): MainScreenViewModel

  @Component.Builder
  interface Builder {

    fun dayComponent(component: DayComponent): Builder

    fun build(): MainScreenComponent

  }

}