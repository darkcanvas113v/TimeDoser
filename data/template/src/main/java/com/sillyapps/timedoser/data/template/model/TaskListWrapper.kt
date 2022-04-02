package com.sillyapps.timedoser.data.template.model

import com.sillyapps.timedoser.domain.template.model.Task
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TaskListWrapper(
  val items: List<Task>
)