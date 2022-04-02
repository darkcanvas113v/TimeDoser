package com.sillyapps.timedoser.task.persistence

import androidx.room.*
import com.sillyapps.timedoser.task.model.TaskDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

  @Query("select * from tasks where id = :id")
  fun getTask(id: Long): TaskDataModel?

  @Query("select * from tasks")
  fun observeAll(): Flow<List<TaskDataModel>>

  @Query("select * from tasks where id = :id")
  fun observeOne(id: Long): Flow<TaskDataModel>

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insert(alarm: TaskDataModel): Long

  @Update
  suspend fun update(alarm: TaskDataModel)

  @Transaction
  suspend fun upsert(alarm: TaskDataModel) {
    val id = insert(alarm)

    if (id == -1L) {
      update(alarm)
    }
  }

}