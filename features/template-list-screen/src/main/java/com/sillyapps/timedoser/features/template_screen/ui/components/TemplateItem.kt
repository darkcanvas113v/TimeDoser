package com.sillyapps.timedoser.features.template_screen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sillyapps.core_time.Time
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.features.template_screen.R
import com.sillyapps.timedoser.features.template_screen.model.TemplateUIModel

@Composable
fun TemplateItem(
  model: TemplateUIModel,
  onClick: (Long) -> Unit
) {
  Surface(
    elevation = 4.dp,
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 8.dp, end = 8.dp, top = 16.dp)
      .clickable { onClick(model.id) }
  ) {
    Row(
      modifier = Modifier
        .height(100.dp)
    ) {
      Box(
        modifier = Modifier
          .background(MaterialTheme.colors.primary)
          .fillMaxHeight()
          .width(56.dp)
      ) {
      }

      Column(
        modifier = Modifier
          .padding(12.dp)
          .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
      ) {
        Text(
          text = model.name,
          overflow = TextOverflow.Ellipsis,
          maxLines = 1,
        )

        Box(modifier = Modifier.fillMaxWidth()) {
          Column(
            modifier = Modifier.align(Alignment.CenterStart),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = stringResource(id = R.string.total_duration),
              style = MaterialTheme.typography.caption,
            )
            Text(
              text = model.totalDuration,
              style = MaterialTheme.typography.body2
            )
          }
          Column(
            modifier = Modifier.align(Alignment.CenterEnd),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = stringResource(id = R.string.task_count),
              style = MaterialTheme.typography.caption,
            )
            Text(
              text = model.taskCount.toString(),
              style = MaterialTheme.typography.body2
            )
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun TaskItemPreview() {
  val template by remember {
    mutableStateOf(
      TemplateUIModel(
        id = 0,
        name = "Template",
        totalDuration = "01:00",
        taskCount = 2
      ))
  }

  TimeDoserTheme() {
    TemplateItem(model = template, onClick = {})
  }
}