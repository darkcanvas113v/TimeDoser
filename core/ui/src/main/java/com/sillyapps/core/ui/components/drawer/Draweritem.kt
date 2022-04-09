package com.sillyapps.core.ui.components.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sillyapps.core.ui.R

@Composable
fun DrawerItem(
  onNavigateTo: (String) -> Unit,
  model: DrawerItemModel,
  isSelected: Boolean
) {
  val color =
    if (isSelected)
      MaterialTheme.colors.primary.copy(alpha = 0.2f)
    else MaterialTheme.colors.background

  val textColor =
    if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

  Row(
    modifier = Modifier
      .padding(top = 8.dp, start = 8.dp, end = 8.dp)
      .fillMaxWidth()
      .clip(MaterialTheme.shapes.small)
      .background(color)
      .clickable { onNavigateTo(model.route) }
      .padding(8.dp),
  ) {
    Icon(
      imageVector = model.iconVector,
      contentDescription = "",
      tint = textColor
    )

    Text(
      text = stringResource(id = model.textResId),
      color = textColor,
      modifier = Modifier.padding(start = 16.dp)
    )
  }
}

@Preview
@Composable
fun DrawerItemPreview() {
  MaterialTheme() {
    Surface() {
      DrawerItem(
        onNavigateTo = {},
        model = DrawerItemModel(
          textResId = R.string.drawer_item_preview_text,
          iconVector = Icons.Filled.List,
          route = "main_screen"
        ),
        isSelected = true
      )
    }
  }
}

data class DrawerItemModel(
  val textResId: Int,
  val iconVector: ImageVector,
  val route: String
)