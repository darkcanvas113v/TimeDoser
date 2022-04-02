package com.sillyapps.timedoser.main_screen.model

data class TaskUIModel(
  val id: Long,
  val startTime: Long,
  val duration: Long,
  val name: String
) {
}