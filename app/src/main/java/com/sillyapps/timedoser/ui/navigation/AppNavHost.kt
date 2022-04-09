package com.sillyapps.timedoser.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.main_screen.api.MainScreenNavigation

@Composable
fun AppNavHost(
  dayRepository: DayRepository
) {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = "") {

    composable(route = "main_screen") {
      MainScreenNavigation(
        repository = dayRepository,
        onItemClick = {})
    }

  }
}