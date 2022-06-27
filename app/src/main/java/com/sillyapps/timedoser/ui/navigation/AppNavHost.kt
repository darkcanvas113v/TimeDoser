package com.sillyapps.timedoser.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.di.DayComponent
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.features.task_editor_screen.api.TaskEditorDialog
import com.sillyapps.timedoser.features.template_screen.api.TemplateListScreenNavigation
import com.sillyapps.timedoser.main_screen.api.MainScreenNavigation
import com.squareup.moshi.Moshi

@Composable
fun AppNavHost(
  templateRepository: TemplateRepository,
  dayComponent: DayComponent,
  navController: NavHostController
) {
  NavHost(
    navController = navController,
    startDestination = Screen.MainScreen.route) {

    composable(route = Screen.MainScreen.route) {
      MainScreenNavigation(
        dayComponent = dayComponent,
        onItemClick = {
          navController.navigate("${Screen.TaskEditorScreen.route}/$it")
        },
        onAddButtonClick = {
          navController.navigate("${Screen.TaskEditorScreen.route}/-1")
        }
      )
    }

    composable(route = Screen.TemplateScreen.route) {
      TemplateListScreenNavigation(
        onItemClick = {},
        onAddButtonClick = { /*TODO*/ },
        templateRepository = templateRepository
      )
    }

    dialog(
      route = "${Screen.TaskEditorScreen.route}/{taskPos}",
      arguments = listOf(
        navArgument("taskPos") {
          type = NavType.IntType
        }
      )
    ) { entry ->
      val taskPosition = entry.arguments?.getInt("taskPos")

      TaskEditorDialog(
        dayComponent = dayComponent,
        onDismiss = { navController.popBackStack() },
        taskPosition = taskPosition
      )
    }

  }
}