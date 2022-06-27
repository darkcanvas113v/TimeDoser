package com.sillyapps.timedoser.features.template_editor_screen.api

import androidx.compose.runtime.Composable
import com.sillyapps.core.ui.daggerViewModel
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.features.template_editor_screen.di.DaggerSaveTemplateDialogComponent
import com.sillyapps.timedoser.features.template_editor_screen.di.SaveTemplateDialogComponent
import com.sillyapps.timedoser.features.template_editor_screen.model.TemplateInfo
import com.sillyapps.timedoser.features.template_editor_screen.ui.SaveTemplateDialogInternal

object SaveTemplateDialogApi {
  private var component: SaveTemplateDialogComponent? = null

  fun initialize(
    templateRepository: TemplateRepository
  ) {
    component = DaggerSaveTemplateDialogComponent.builder()
      .templateRepository(templateRepository)
      .build()
  }

  internal fun getComponent(): SaveTemplateDialogComponent? = component
}

@Composable
fun SaveTemplateDialog(
  onDismiss: () -> Unit
) {
  val component = SaveTemplateDialogApi.getComponent()
    ?: throw KotlinNullPointerException("SaveTemplateDialog module is not initialized")

  val viewModel = daggerViewModel() {
    component.getViewModel()
  }

  SaveTemplateDialogInternal(
    onDismiss = onDismiss,
    stateHolder = viewModel
  )
}