package com.sillyapps.timedoser.data.template

import android.content.SharedPreferences
import javax.inject.Inject

class DefaultTemplateDataSource @Inject constructor(
  private val sharedPreferences: SharedPreferences
) {

  fun getDefaultTemplateId(): Long? {
    val id = sharedPreferences.getLong(DEFAULT_TEMPLATE_ID, -1)

    if (id == -1L) return null
    return id
  }

  fun updateDefaultTemplate(id: Long) {
    sharedPreferences.edit().putLong(DEFAULT_TEMPLATE_ID, id).apply()
  }

  companion object {
    const val DEFAULT_TEMPLATE_ID = "DEFAULT_TEMPLATE_ID"
  }

}