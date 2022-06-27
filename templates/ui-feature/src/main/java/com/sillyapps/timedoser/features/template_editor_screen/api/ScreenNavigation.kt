package com.sillyapps.timedoser.features.template_editor_screen.api

import androidx.compose.runtime.Composable
import com.sillyapps.core.ui.daggerViewModel
import com.sillyapps.timedoser.features.template_editor_screen.di.DaggerScreenComponent
import com.sillyapps.timedoser.features.template_editor_screen.ui.Screen

@Composable
fun ScreenNavigation() {

  val component = DaggerScreenComponent.builder()
    .build()

  val viewModel = daggerViewModel {
    component.getViewModel()
  }

  Screen(
    stateHolder = viewModel
  )

}