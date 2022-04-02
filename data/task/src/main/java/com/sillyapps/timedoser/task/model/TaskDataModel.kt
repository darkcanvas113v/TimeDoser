package com.sillyapps.timedoser.task.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sillyapps.timedoser.domain.task.model.Task

@Entity(tableName = "tasks")
data class TaskDataModel(
  @PrimaryKey(autoGenerate = true) val id: Long,
  val startTime: Long,
  val name: String
)

fun TaskDataModel.toDomainModel(): Task {
  return Task(
    id = id,
    startTime = startTime,
    name = name
  )
}

fun Task.toDataModel(): TaskDataModel {
  return TaskDataModel(
    id = id,
    name = name,
    startTime = startTime
  )
}