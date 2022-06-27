package com.sillyapps.timedoser.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import com.sillyapps.core.ui.components.drawer.DrawerItemModel
import com.sillyapps.timedoser.R

val drawerItems = listOf(
  Screen.MainScreen.run {
    DrawerItemModel(
      textResId = R.string.main_screen,
      iconVector = Icons.Filled.List,
      route = Screen.MainScreen.route
    )
  },
  Screen.TemplateScreen.run {
    DrawerItemModel(
      textResId = R.string.template_screen,
      iconVector = Icons.Filled.List,
      route = Screen.TemplateScreen.route
    )
  },
)