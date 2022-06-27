package com.sillyapps.timedoser.features.template_editor_screen.di

import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.features.template_editor_screen.ui.SaveTemplateDialogViewModel
import dagger.BindsInstance
import dagger.Component

@Component
interface SaveTemplateDialogComponent {

  fun getViewModel(): SaveTemplateDialogViewModel

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun templateRepository(repository: TemplateRepository): Builder

    fun build(): SaveTemplateDialogComponent
  }

}