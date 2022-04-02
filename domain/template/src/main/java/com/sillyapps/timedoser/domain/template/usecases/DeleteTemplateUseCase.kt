package com.sillyapps.timedoser.domain.template.usecases

import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.domain.template.model.Template
import javax.inject.Inject

class DeleteTemplateUseCase @Inject constructor(
  private val repository: TemplateRepository
) {
  suspend operator fun invoke(template: Template) {

  }
}