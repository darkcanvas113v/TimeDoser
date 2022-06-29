package com.sillyapps.timedoser.main_screen.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.main_screen.model.MainScreenState
import com.sillyapps.timedoser.main_screen.model.toUIModel
import com.sillyapps.timedoser.main_screen.ui.components.DefaultFragment
import com.sillyapps.timedoser.main_screen.ui.components.LoadingFragment

@Composable
fun MainScreen(
  stateHolder: MainScreenStateHolder,
  onEmptyButtonClick: () -> Unit,
  onItemClick: (Int) -> Unit,
  onAddButtonClick: () -> Unit
) {

  val state by remember(stateHolder) {
    stateHolder.getState()
  }.collectAsState(initial = MainScreenState.INITIAL)

  Surface {
    Column(modifier = Modifier.fillMaxSize()) {
      Box(modifier = Modifier.weight(1f)) {
        when (state.state) {
          MainScreenState.STATE_LOADING -> {
            LoadingFragment()
          }
          MainScreenState.STATE_SUCCESS -> {
            DefaultFragment(
              onItemClick = onItemClick,
              tasks = state.tasks
            )
          }
        }
      }

      BottomToolbar(
        onAddButtonClick = onAddButtonClick,
        onPauseButtonClick = { stateHolder.pause() },
        onPlayButtonClick = { stateHolder.start() },
        onStopButtonClick = { stateHolder.stop() },
        dayState = state.dayState
      )
    }
  }
}

