package com.sillyapps.timedoser.data.day

import android.content.SharedPreferences
import com.sillyapps.timedoser.data.day.model.DayDataModel
import com.sillyapps.timedoser.data.day.model.toDataModel
import com.sillyapps.timedoser.domain.model.Day
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class DayDataSourceImpl @Inject constructor(
  private val sharedPref: SharedPreferences
): DayDataSource {

  private val adapter = Moshi.Builder().build().adapter(DayDataModel::class.java)

  private val model = MutableStateFlow(Day.EMPTY)

  override fun get(): Flow<Day> {
    return model
  }

  override fun getRaw(): Day {
    return model.value
  }

  override fun set(day: Day) {
    model.value = day
  }

  override fun save() {
    val data = adapter.toJson(model.value.toDataModel())
    sharedPref.edit().putString(CACHED_DAY, data).apply()
  }

  override fun load() {
//    val json = sharedPref.getString(CACHED_DAY, null) ?: return null
//
//    adapter.fromJson(json)
  }

  companion object {
    private const val CACHED_DAY = "CACHED_DAY"
  }

}