package com.sillyapps.timedoser.features.task_editor_screen.di

import com.sillyapps.core.di.ScreenScope
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.di.DayComponent
import com.sillyapps.timedoser.features.task_editor_screen.ui.TaskEditorViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@ScreenScope
@Component(dependencies = [DayComponent::class])
interface TaskEditorScreenComponent {

  fun getViewModel(): TaskEditorViewModel

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun taskPosition(@TaskPosition taskPosition: Int): Builder

    fun dayComponent(component: DayComponent): Builder

    fun build(): TaskEditorScreenComponent
  }

}

@Qualifier
annotation class TaskPosition