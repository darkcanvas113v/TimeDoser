package com.sillyapps.timedoser.ui.navigation

import androidx.annotation.IdRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.sillyapps.timedoser.R

sealed class Screen(val route: String) {
  object MainScreen: Screen(
    route = "main_screen"
  )

  object TemplateScreen: Screen(
    route = "template_screen"
  )

  object TaskEditorScreen: Screen(
    route = "task_editor_screen"
  )
}
