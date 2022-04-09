package com.sillyapps.timedoser.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import com.sillyapps.core.ui.components.drawer.DrawerItemModel
import com.sillyapps.timedoser.R

val drawerItems = listOf(
  DrawerItemModel(
    textResId = R.string.main_screen,
    iconVector = Icons.Filled.List,
    route = "main_screen"
  ),
  DrawerItemModel(
    textResId = R.string.template_screen,
    iconVector = Icons.Filled.List,
    route = "template_screen"
  ),
)