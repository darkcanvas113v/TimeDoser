package com.sillyapps.timedoser.domain.task.model

data class Task(
  val id: Long,
  val startTime: Long,
  val name: String
)