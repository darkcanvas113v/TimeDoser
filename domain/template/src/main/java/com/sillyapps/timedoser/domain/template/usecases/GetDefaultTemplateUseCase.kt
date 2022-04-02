package com.sillyapps.timedoser.domain.template.usecases

import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.domain.template.model.Template
import javax.inject.Inject

class GetDefaultTemplateUseCase @Inject constructor(
  private val repository: TemplateRepository
) {

  suspend fun invoke(): Template? {
    return repository.getDefaultTemplate()
  }

}