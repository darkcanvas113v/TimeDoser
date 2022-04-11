package com.sillyapps.timedoser.features.template_screen.ui

import com.sillyapps.timedoser.features.template_screen.model.TemplateUIModel
import kotlinx.coroutines.flow.Flow

interface TemplateListStateHolder {

  fun getTemplates(): Flow<List<TemplateUIModel>>

}