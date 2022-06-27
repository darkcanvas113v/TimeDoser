package com.sillyapps.timedoser.main_screen.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.main_screen.model.toUIModel
import com.sillyapps.timedoser.main_screen.ui.components.DefaultFragment
import com.sillyapps.timedoser.main_screen.ui.components.EmptyFragment
import com.sillyapps.timedoser.main_screen.ui.components.LoadingFragment

@Composable
fun MainScreen(
  stateHolder: MainScreenStateHolder,
  onEmptyButtonClick: () -> Unit,
  onItemClick: (Int) -> Unit,
  onAddButtonClick: () -> Unit
) {

  val state by remember(stateHolder) {
    stateHolder.getDay()
  }.collectAsState(initial = DataState.Loading())

  Surface {
    Column(modifier = Modifier.fillMaxSize()) {
      Box(modifier = Modifier.weight(1f)) {
        when (val s = state) {
          is DataState.Empty -> {
            EmptyFragment(onEmptyButtonClick = onEmptyButtonClick)
          }
          is DataState.Error -> {

          }
          is DataState.Loading, is DataState.InitialState -> {
            LoadingFragment()
          }
          is DataState.Success -> {
            DefaultFragment(
              onItemClick = onItemClick,
              tasks = s.data.tasks.map { it.toUIModel() }
            )
          }
        }
      }

      BottomToolbar(
        onAddButtonClick = onAddButtonClick,
        onPauseButtonClick = { stateHolder.pause() },
        onPlayButtonClick = { stateHolder.start() },
        onStopButtonClick = { stateHolder.stop() }
      )
    }
  }
}

@Composable
fun BottomToolbar(
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

    IconButton(onClick = onPlayButtonClick) {
      Icon(
        imageVector = Icons.Filled.PlayArrow,
        contentDescription = null,
        modifier = Modifier.size(32.dp)
      )
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
        onStopButtonClick = {}
      )
    }
  }
}