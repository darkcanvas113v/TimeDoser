package com.sillyapps.timedoser.features.template_screen.api

import androidx.compose.runtime.Composable
import com.sillyapps.core.ui.daggerViewModel
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.features.template_screen.di.DaggerTemplateListScreenComponent
import com.sillyapps.timedoser.features.template_screen.ui.TemplateListScreen

@Composable
fun TemplateListScreenNavigation(
  onItemClick: (Long) -> Unit,
  onAddButtonClick: () -> Unit,
  templateRepository: TemplateRepository,
) {

  val component = DaggerTemplateListScreenComponent.builder()
    .templateRepository(templateRepository)
    .build()

  val viewModel = daggerViewModel {
    component.getViewModel()
  }

  TemplateListScreen(
    stateHolder = viewModel,
    onItemClick = onItemClick,
    onAddButtonClick = onAddButtonClick
  )

}