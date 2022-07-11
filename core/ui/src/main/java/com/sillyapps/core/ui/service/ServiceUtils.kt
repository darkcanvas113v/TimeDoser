package com.sillyapps.core.ui.service

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.content.ContextCompat

fun getImmutablePendingIntentFlags(): Int {
  var piFlags = PendingIntent.FLAG_UPDATE_CURRENT
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    piFlags = piFlags or PendingIntent.FLAG_IMMUTABLE
  }
  return piFlags
}

fun startForegroundServiceCompat(context: Context, intent: Intent) {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
    ContextCompat.startForegroundService(context, intent)
  else
    context.startService(intent)
}