package com.sillyapps.timedoser.data.template.model

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi

object TaskListConverter {

  private val adapter = Moshi.Builder().build().adapter(TaskListWrapper::class.java)

  @TypeConverter
  fun fromTaskListToString(tasks: TaskListWrapper): String = adapter.toJson(tasks)

  @TypeConverter
  fun fromStringToTaskList(data: String): TaskListWrapper? = adapter.fromJson(data)

}