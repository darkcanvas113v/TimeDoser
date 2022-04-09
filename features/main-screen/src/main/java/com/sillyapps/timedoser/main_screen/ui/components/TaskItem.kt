package com.sillyapps.timedoser.main_screen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Radio
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sillyapps.core_time.AlarmConstants
import com.sillyapps.core_time.Time
import com.sillyapps.core_time.convertMillisToStringFormat
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.main_screen.model.TaskUIModel

@Composable
fun TaskItem(
  task: TaskUIModel
) {
  Surface(
    elevation = 4.dp,
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 8.dp, end = 8.dp, top = 8.dp)
  ) {
    Row(
      modifier = Modifier
        .height(90.dp)
    ) {
      Box(
        modifier = Modifier
          .background(MaterialTheme.colors.primary)
          .fillMaxHeight()
      ) {
        Box(
          modifier = Modifier
            .padding(top = 8.dp)
            .size(32.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.onPrimary)
            .align(Alignment.TopCenter)
        ) {
          Icon(
            imageVector = Icons.Filled.Radio,
            contentDescription = "",
            modifier = Modifier
              .fillMaxSize()
              .padding(4.dp)
          )
        }
        
        Text(
          text = task.startTime,
          style = MaterialTheme.typography.subtitle1,
          color = MaterialTheme.colors.onPrimary,
          modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(top = 16.dp, bottom = 8.dp)
            .padding(horizontal = 4.dp)
        )
      }
      
      Column(
        modifier = Modifier
          .padding(12.dp)
          .fillMaxHeight()
      ) {
        Text(
          text = task.name,
          overflow = TextOverflow.Ellipsis,
          maxLines = 1,
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        Box(modifier = Modifier.fillMaxWidth()) {
          Text(
            text = task.progress,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.align(Alignment.CenterStart)
          )
          Text(
            text = task.timeRemained,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.align(Alignment.CenterEnd)
          )
        }

        LinearProgressIndicator(
          progress = task.relativeProgress,
          modifier = Modifier
            .padding(top = 2.dp)
            .fillMaxWidth()
        )
      }
    }
  }
}

@Preview
@Composable
fun TaskItemPreview() {
  val task by remember {
    mutableStateOf(
      TaskUIModel(
        startTime = "00:00",
        duration = 10 * Time.m,
        name = "Task",
        state = RunningTask.State.ACTIVE,
        progress = "00:05:00",
        timeRemained = "00:05:00",
        relativeProgress = 0.5f,
      ))
  }

  TimeDoserTheme() {
    TaskItem(task)
  }
}