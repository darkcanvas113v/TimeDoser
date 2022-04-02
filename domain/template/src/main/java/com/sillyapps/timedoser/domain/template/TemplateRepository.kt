package com.sillyapps.timedoser.domain.template

import com.sillyapps.timedoser.domain.template.model.Template
import kotlinx.coroutines.flow.Flow

interface TemplateRepository {

  fun getAllTemplates(): Flow<List<Template>>

  suspend fun getDefaultTemplate(): Template?

  fun getTemplate(id: Long): Flow<Template?>

  suspend fun upsertTemplate(template: Template)

  suspend fun deleteTemplate(template: Template)

}