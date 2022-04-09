package com.sillyapps.timedoser.ui

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.ui.navigation.AppNavHost

@Composable
fun RootContainer(
  dayRepository: DayRepository
) {
  TimeDoserTheme {
    Surface() {
      AppNavHost(
        dayRepository = dayRepository)
    }
  }
}