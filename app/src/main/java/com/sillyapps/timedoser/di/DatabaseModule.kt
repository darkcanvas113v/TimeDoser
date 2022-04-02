package com.sillyapps.timedoser.di

import android.content.Context
import com.sillyapps.core.di.AppScope
import com.sillyapps.timedoser.data.AppDatabase
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {

  @AppScope
  @Provides
  fun provideDatabase(context: Context) = AppDatabase.getInstance(context)

}