package com.sillyapps.timedoser.di

import android.content.Context
import com.sillyapps.core.di.AppScope
import com.sillyapps.timedoser.data.AppDatabase
import dagger.Module
import dagger.Provides

@Module
object PersistenceModule {

  @AppScope
  @Provides
  fun provideDatabase(context: Context) = AppDatabase.getInstance(context)

  @AppScope
  @Provides
  fun provideSharedPref(context: Context) = context.getSharedPreferences(SharedPref.TAG, Context.MODE_PRIVATE)

}

object SharedPref {
  const val TAG = "TimeDoserSharedPreferences"
}