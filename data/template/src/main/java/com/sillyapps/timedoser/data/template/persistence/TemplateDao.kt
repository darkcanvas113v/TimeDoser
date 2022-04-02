package com.sillyapps.timedoser.data.template.persistence

import androidx.room.*
import com.sillyapps.timedoser.data.template.model.TemplateDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TemplateDao {

  @Query("select * from templates where id = :id")
  fun getTemplate(id: Long): TemplateDataModel?

  @Query("select * from templates order by id asc limit 1")
  suspend fun getFirstExistingTemplate(): TemplateDataModel?

  @Query("select * from templates")
  fun observeAll(): Flow<List<TemplateDataModel>>

  @Query("select * from templates where id = :id")
  fun observeOne(id: Long): Flow<TemplateDataModel?>

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insert(template: TemplateDataModel): Long

  @Update
  suspend fun update(template: TemplateDataModel)

  @Delete
  suspend fun delete(template: TemplateDataModel)

  @Transaction
  suspend fun upsert(alarm: TemplateDataModel) {
    val id = insert(alarm)

    if (id == -1L) {
      update(alarm)
    }
  }

}