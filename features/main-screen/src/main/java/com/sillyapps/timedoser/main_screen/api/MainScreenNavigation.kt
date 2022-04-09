package com.sillyapps.timedoser.main_screen.api

import androidx.compose.runtime.Composable
import com.sillyapps.core.ui.daggerViewModel
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.main_screen.di.DaggerMainScreenComponent
import com.sillyapps.timedoser.main_screen.ui.MainScreen

@Composable
fun MainScreenNavigation(
  repository: DayRepository,
  onItemClick: (Int) -> Unit
) {

  val component = DaggerMainScreenComponent.builder()
    .repository(repository)
    .build()

  val viewModel = daggerViewModel { component.getViewModel() }

  MainScreen(
    stateHolder = viewModel,
    onItemClick = onItemClick,
    onEmptyButtonClick = {}
  )

}