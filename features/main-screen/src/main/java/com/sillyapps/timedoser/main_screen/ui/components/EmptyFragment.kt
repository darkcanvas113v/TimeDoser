package com.sillyapps.timedoser.main_screen.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sillyapps.timedoser.main_screen.R

@Composable
fun EmptyFragment(
  onEmptyButtonClick: () -> Unit
) {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = stringResource(id = R.string.no_template_found))

    TextButton(
      onClick = onEmptyButtonClick,
      modifier = Modifier.padding(top = 8.dp)
    ) {
      Text(text = stringResource(id = R.string.create_template))
    }
  }
}