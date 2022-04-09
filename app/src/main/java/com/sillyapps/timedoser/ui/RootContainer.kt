package com.sillyapps.timedoser.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.sillyapps.core.ui.components.drawer.DrawerContent
import com.sillyapps.timedoser.R
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.ui.navigation.AppNavHost

@Composable
fun RootContainer(
  dayRepository: DayRepository
) {
  val scaffoldState = rememberScaffoldState()
  val navController = rememberNavController()

  TimeDoserTheme {
    Scaffold(
      scaffoldState = scaffoldState,
      drawerContent = {
        DrawerContent(
          items = drawerItems,
          onNavigateTo = {}
        )
      }
    ) {
      AppNavHost(
        dayRepository = dayRepository,
        navController = navController
      )
    }
  }
}