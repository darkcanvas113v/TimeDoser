package com.sillyapps.timedoser.data.template.persistence

interface TemplateDatabase {
  fun provideTaskDao(): TemplateDao
}