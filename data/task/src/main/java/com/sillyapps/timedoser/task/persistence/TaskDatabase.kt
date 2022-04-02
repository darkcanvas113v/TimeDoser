package com.sillyapps.timedoser.task.persistence

interface TaskDatabase {
  fun provideTaskDao(): TaskDao
}