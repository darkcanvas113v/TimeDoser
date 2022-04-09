package com.sillyapps.timedoser.main_screen.di

import com.sillyapps.core.di.ScreenScope
import com.sillyapps.core_util.ticker.TickerModule
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.main_screen.ui.MainScreenViewModel
import dagger.BindsInstance
import dagger.Component

@ScreenScope
@Component(modules = [TickerModule::class])
interface MainScreenComponent {

  fun getViewModel(): MainScreenViewModel

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun repository(repository: DayRepository): Builder

    fun build(): MainScreenComponent

  }

}