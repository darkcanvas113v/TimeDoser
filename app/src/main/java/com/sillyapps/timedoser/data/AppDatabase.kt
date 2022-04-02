package com.sillyapps.timedoser.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sillyapps.timedoser.task.di.TaskDataComponent
import com.sillyapps.timedoser.task.model.TaskDataModel
import com.sillyapps.timedoser.task.persistence.TaskDao
import com.sillyapps.timedoser.task.persistence.TaskDatabase

@Database(entities = [TaskDataModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(), TaskDatabase {

  abstract val taskDao: TaskDao

  override fun provideTaskDao(): TaskDao {
    return taskDao
  }

  companion object {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
      synchronized(this) {
        var instance = INSTANCE

        if (instance == null) {
          instance = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "timedoser_database")
            .fallbackToDestructiveMigration()
            .build()

          INSTANCE = instance
        }

        return instance
      }
    }

  }
}