package com.sillyapps.timedoser.main_screen.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.main_screen.model.toUIModel
import com.sillyapps.timedoser.main_screen.ui.components.DefaultFragment
import com.sillyapps.timedoser.main_screen.ui.components.EmptyFragment
import com.sillyapps.timedoser.main_screen.ui.components.LoadingFragment

@Composable
fun MainScreen(
  stateHolder: MainScreenStateHolder,
  onEmptyButtonClick: () -> Unit,
  onItemClick: (Int) -> Unit
) {

  val state by remember(stateHolder) {
    stateHolder.getDay()
  }.collectAsState(initial = DataState.Loading())

  Surface(
    modifier = Modifier.fillMaxSize()
  ) {
    when (val s = state) {
      is DataState.Empty -> {
        EmptyFragment(onEmptyButtonClick = onEmptyButtonClick)
      }
      is DataState.Error -> {

      }
      is DataState.Loading -> {
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
}