package com.sillyapps.timedoser.features.template_screen.model

import com.sillyapps.core_time.convertMillisToStringFormat
import com.sillyapps.timedoser.domain.template.model.Template

data class TemplateUIModel(
  val id: Long,
  val name: String,
  val totalDuration: String,
  val taskCount: Int
)

fun Template.toUIModel(): TemplateUIModel {
  return TemplateUIModel(
    id = id,
    name = name,
    totalDuration = kotlin.run {
      var duration = 0L
      tasks.forEach { duration += it.duration }
      convertMillisToStringFormat(duration)
    },
    taskCount = tasks.size
  )
}