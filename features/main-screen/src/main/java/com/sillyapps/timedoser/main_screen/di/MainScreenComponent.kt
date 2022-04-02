package com.sillyapps.timedoser.main_screen.di

import com.sillyapps.core.di.ScreenScope
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.main_screen.ui.MainScreenViewModel
import dagger.BindsInstance
import dagger.Component

@ScreenScope
@Component(modules = [])
interface MainScreenComponent {

  fun getViewModel(): MainScreenViewModel

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun repository(repository: TemplateRepository): Builder

    fun build(): MainScreenComponent

  }

}