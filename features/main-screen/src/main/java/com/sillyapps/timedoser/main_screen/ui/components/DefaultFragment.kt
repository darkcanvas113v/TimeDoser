package com.sillyapps.timedoser.main_screen.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sillyapps.core_time.Time
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.main_screen.model.TaskUIModel

@Composable
fun DefaultFragment(
  onItemClick: (Int) -> Unit,
  tasks: List<TaskUIModel>
) {
  
  LazyColumn() {
    items(
      items = tasks
    ) { task ->
      TaskItem(task = task)
    }
  }
  
}

@Preview
@Composable
fun DefaultFragmentPreview() {
  val items = remember {
    mutableStateListOf(
      TaskUIModel(
        startTime = "00:00",
        duration = 10 * Time.m,
        name = "Task",
        state = RunningTask.State.ACTIVE,
        progress = "00:05:00",
        timeRemained = "00:05:00",
        relativeProgress = 0.5f,
      ),
      TaskUIModel(
        startTime = "00:00",
        duration = 10 * Time.m,
        name = "Task",
        state = RunningTask.State.WAITING,
        progress = "00:05:00",
        timeRemained = "00:05:00",
        relativeProgress = 0.5f,
      ),
    )
  }

  TimeDoserTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      DefaultFragment(
        onItemClick = {},
        tasks = items)
    }
  }
}