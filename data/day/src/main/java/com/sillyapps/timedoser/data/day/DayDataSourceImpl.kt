package com.sillyapps.timedoser.data.day

import android.content.SharedPreferences
import com.sillyapps.timedoser.data.day.model.DayDataModel
import com.sillyapps.timedoser.domain.model.Day
import com.squareup.moshi.Moshi
import javax.inject.Inject

class DayDataSourceImpl @Inject constructor(
  private val sharedPref: SharedPreferences
): DayDataSource {

  private val adapter = Moshi.Builder().build().adapter(DayDataModel::class.java)

  override fun saveDay(day: DayDataModel) {
    val data = adapter.toJson(day)
    sharedPref.edit().putString(CACHED_DAY, data).apply()
  }

  override fun loadDay(): DayDataModel? {
    val json = sharedPref.getString(CACHED_DAY, null) ?: return null

    return adapter.fromJson(json)
  }

  companion object {
    private const val CACHED_DAY = "CACHED_DAY"
  }

}