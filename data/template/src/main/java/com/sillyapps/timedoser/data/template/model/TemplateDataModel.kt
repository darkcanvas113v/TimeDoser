package com.sillyapps.timedoser.data.template.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sillyapps.timedoser.domain.template.model.Task
import com.sillyapps.timedoser.domain.template.model.Template

@Entity(tableName = "templates")
data class TemplateDataModel(
  @PrimaryKey(autoGenerate = true) val id: Long,
  val name: String,
  val tasks: TaskListWrapper
)

fun TemplateDataModel.toDomainModel(): Template {
  return Template(
    id = id,
    name = name,
    tasks = tasks.items
  )
}

fun Template.toDataModel(): TemplateDataModel {
  return TemplateDataModel(
    id = id,
    name = name,
    tasks = TaskListWrapper(tasks)
  )
}