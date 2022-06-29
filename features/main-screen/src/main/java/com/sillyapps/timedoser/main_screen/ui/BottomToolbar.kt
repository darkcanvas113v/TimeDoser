package com.sillyapps.timedoser.main_screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask

@Composable
fun BottomToolbar(
  dayState: Int,
  onPlayButtonClick: () -> Unit,
  onStopButtonClick: () -> Unit,
  onAddButtonClick: () -> Unit,
  onPauseButtonClick: () -> Unit
) {
  Row(
    horizontalArrangement = Arrangement.SpaceAround,
    modifier = Modifier.fillMaxWidth()
  ) {
    IconButton(onClick = onStopButtonClick) {
      Icon(
        imageVector = Icons.Filled.Stop,
        contentDescription = null,
        modifier = Modifier.size(32.dp)
      )
    }

    if (dayState == Day.State.WAITING.ordinal) {
      IconButton(onClick = onPlayButtonClick) {
        Icon(
          imageVector = Icons.Filled.PlayArrow,
          contentDescription = null,
          modifier = Modifier.size(32.dp)
        )
      }
    }
    else {
      IconButton(onClick = onPauseButtonClick) {
        Icon(
          imageVector = Icons.Filled.Pause,
          contentDescription = null,
          modifier = Modifier.size(32.dp)
        )
      }
    }

    IconButton(onClick = onAddButtonClick) {
      Icon(
        imageVector = Icons.Filled.Add,
        contentDescription = null,
        modifier = Modifier.size(32.dp)
      )
    }
  }
}

@Preview
@Composable
fun BottomToolbarPreview() {
  TimeDoserTheme() {
    Surface {
      BottomToolbar(
        onAddButtonClick = {},
        onPauseButtonClick = {},
        onPlayButtonClick = {},
        onStopButtonClick = {},
        dayState = Day.State.WAITING.ordinal
      )
    }
  }
}