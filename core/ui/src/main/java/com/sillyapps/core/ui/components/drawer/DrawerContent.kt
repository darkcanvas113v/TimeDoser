package com.sillyapps.core.ui.components.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sillyapps.core.ui.R

@Composable
fun ColumnScope.DrawerContent(
  items: List<DrawerItemModel>,
  onNavigateTo: (String) -> Unit
) {
  var currentItemId by remember {
    mutableStateOf(0)
  }

  Text(
    text = "Drawer title",
    style = MaterialTheme.typography.h5,
    modifier = Modifier
      .padding(8.dp)
  )

  Divider()

  Column() {
    items.forEachIndexed() { pos, model ->
      DrawerItem(
        onNavigateTo = { route ->
          currentItemId = pos
          onNavigateTo(model.route)
        },
        model = model,
        isSelected = currentItemId == pos
      )
    }
  }
}

@Preview
@Composable
fun DrawerPreview() {
  MaterialTheme() {
    Surface() {
      Column() {
        DrawerContent(
          items = listOf(
            DrawerItemModel(
              textResId = R.string.drawer_item_preview_text,
              iconVector = Icons.Filled.List,
              route = "main_screen"
            ),
            DrawerItemModel(
              textResId = R.string.drawer_item_preview_text,
              iconVector = Icons.Filled.List,
              route = "main_screen"
            ),
            DrawerItemModel(
              textResId = R.string.drawer_item_preview_text,
              iconVector = Icons.Filled.List,
              route = "main_screen"
            ),
          ),
          onNavigateTo = {})
      }
    }
  }
}

