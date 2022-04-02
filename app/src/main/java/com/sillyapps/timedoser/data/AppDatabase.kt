package com.sillyapps.timedoser.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sillyapps.timedoser.data.template.model.TaskListConverter
import com.sillyapps.timedoser.data.template.model.TemplateDataModel
import com.sillyapps.timedoser.data.template.persistence.TemplateDao
import com.sillyapps.timedoser.data.template.persistence.TemplateDatabase

@Database(entities = [TemplateDataModel::class], version = 1, exportSchema = false)
@TypeConverters(TaskListConverter::class)
abstract class AppDatabase: RoomDatabase(), TemplateDatabase {

  abstract val templateDao: TemplateDao

  override fun provideTaskDao(): TemplateDao {
    return templateDao
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