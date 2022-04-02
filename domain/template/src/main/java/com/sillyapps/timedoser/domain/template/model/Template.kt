package com.sillyapps.timedoser.domain.template.model

data class Template(
  val id: Long,
  val name: String,
  val tasks: List<Task>
)