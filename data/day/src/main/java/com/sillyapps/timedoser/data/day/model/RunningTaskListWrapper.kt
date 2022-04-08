package com.sillyapps.timedoser.data.day.model

import com.sillyapps.timedoser.domain.model.RunningTask
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RunningTaskListWrapper(
  val items: List<RunningTask>
)