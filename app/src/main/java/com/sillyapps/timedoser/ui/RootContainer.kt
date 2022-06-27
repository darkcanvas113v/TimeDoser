package com.sillyapps.timedoser.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.sillyapps.core.ui.components.drawer.DrawerContent
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.di.DayComponent
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.ui.navigation.AppNavHost
import com.sillyapps.timedoser.ui.navigation.drawerItems
import kotlinx.coroutines.launch

@Composable
fun RootContainer(
  dayComponent: DayComponent,
  templateRepository: TemplateRepository
) {
  val scaffoldState = rememberScaffoldState()
  val navController = rememberNavController()

  val scope = rememberCoroutineScope()

  TimeDoserTheme {
    Scaffold(
      scaffoldState = scaffoldState,
      topBar = {
        TopAppBar(
          title = {},
          navigationIcon = {
            IconButton(
              onClick = {
                scope.launch {
                  scaffoldState.drawerState.apply {
                    if (isClosed) open() else close()
                  }
                }
              }
            ) {
              Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            }
          }
        )
      },
      drawerContent = {
        DrawerContent(
          items = drawerItems,
          navController = navController
        )
      }
    ) {
      AppNavHost(
        dayComponent = dayComponent,
        navController = navController,
        templateRepository = templateRepository
      )
    }
  }
}