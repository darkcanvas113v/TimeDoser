package com.sillyapps.timedoser.features.template_screen.ui

import androidx.lifecycle.ViewModel
import com.sillyapps.timedoser.domain.template.usecases.GetAllTemplatesUseCase
import com.sillyapps.timedoser.features.template_screen.model.TemplateUIModel
import com.sillyapps.timedoser.features.template_screen.model.toUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TemplateListViewModel @Inject constructor(
  private val getAllTemplatesUseCase: GetAllTemplatesUseCase
): ViewModel(), TemplateListStateHolder {

  override fun getTemplates(): Flow<List<TemplateUIModel>> {
    return getAllTemplatesUseCase().map { it.map { template -> template.toUIModel() } }
  }


}