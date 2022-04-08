package com.sillyapps.timedoser.data.day.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.timedoser.data.day.DayDataSource
import com.sillyapps.timedoser.data.day.DayDataSourceImpl
import com.sillyapps.timedoser.data.day.DayRepositoryImpl
import com.sillyapps.timedoser.domain.DayRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
  @AppScope
  @Binds
  fun bindDayRepository(repositoryImpl: DayRepositoryImpl): DayRepository

  @AppScope
  @Binds
  fun bindDayDataSource(dataSource: DayDataSourceImpl): DayDataSource
}