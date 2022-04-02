package com.sillyapps.timedoser.domain.template.usecases

import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.domain.template.model.Template
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTemplatesUseCase @Inject constructor(
  private val repository: TemplateRepository
) {

  operator fun invoke(): Flow<List<Template>> {
    return repository.getAllTemplates()
  }

}