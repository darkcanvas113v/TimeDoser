package com.sillyapps.timedoser.domain.template.model

data class Task(
  val startTime: Long,
  val duration: Long,
  val name: String
)