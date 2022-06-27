package com.sillyapps.timedoser.features.template_editor_screen.di

import com.sillyapps.timedoser.features.template_editor_screen.ui.ScreenViewModel
import dagger.Component

@Component(modules = [])
interface ScreenComponent {

  fun getViewModel(): ScreenViewModel

  @Component.Builder
  interface Builder {
    fun build(): ScreenComponent
  }

}