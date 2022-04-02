package com.sillyapps.timedoser.main_screen.ui

import androidx.lifecycle.ViewModel
import com.sillyapps.timedoser.domain.template.usecases.GetAllTemplatesUseCase
import com.sillyapps.timedoser.domain.template.usecases.GetDefaultTemplateUseCase
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
  private val getDefaultTemplateUseCase: GetDefaultTemplateUseCase
): ViewModel(), MainScreenStateHolder {



}