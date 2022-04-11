package com.sillyapps.timedoser.features.template_screen.di

import com.sillyapps.core.di.FeatureScope
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.features.template_screen.ui.TemplateListViewModel
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(modules = [])
interface TemplateListScreenComponent {

  fun getViewModel(): TemplateListViewModel

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun templateRepository(repository: TemplateRepository): Builder

    fun build(): TemplateListScreenComponent

  }

}