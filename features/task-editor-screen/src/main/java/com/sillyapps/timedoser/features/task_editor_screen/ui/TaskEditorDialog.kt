package com.sillyapps.timedoser.features.task_editor_screen.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sillyapps.core_time.convertMillisToStringFormat
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.features.task_editor_screen.R
import com.sillyapps.timedoser.features.task_editor_screen.models.TaskEditorModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.sillyapps.timedoser.common.lang.R as lang

@Composable
fun TaskEditorDialogContent(
  onDismiss: () -> Unit,
  stateHolder: TaskEditorStateHolder
) {
  val task by remember(stateHolder) {
    stateHolder.getTask()
  }.collectAsState(initial = TaskEditorModel.DEFAULT_VALUE)

  Surface(
    shape = MaterialTheme.shapes.small
  ) {
    Column(
      modifier = Modifier
        .padding(vertical = 16.dp)
        .padding(horizontal = 12.dp)
        .width(IntrinsicSize.Min)
    ) {
      Text(
        text = stringResource(id = R.string.edit_task),
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(bottom = 16.dp)
      )

      OutlinedTextField(
        value = task.name,
        onValueChange = {
          stateHolder.setName(name = it)
        },
        label = { Text(text = stringResource(id = lang.string.name)) }
      )

      Column(
        modifier = Modifier
          .padding(top = 32.dp)
      ) {
        Text(
          text = stringResource(id = lang.string.duration),
          style = MaterialTheme.typography.caption,
          modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedButton(
          onClick = {},
        ) {
          Text(
            text = convertMillisToStringFormat(task.duration),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 0.dp, vertical = 8.dp)
          )
        }

      }

      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 32.dp)
      ) {
        Button(
          onClick = onDismiss,
          colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black.copy(alpha = 0.07f),
            contentColor = Color.Black
          ),
          elevation = null,
          modifier = Modifier.width(90.dp)
        ) {
          Text(text = stringResource(id = lang.string.cancel))
        }

        Button(
          onClick = {
            stateHolder.save()
            onDismiss()
          },
          modifier = Modifier.width(90.dp)
        ) {
          Text(text = stringResource(id = lang.string.save))
        }
      }
    }
  }
}

@Preview
@Composable
fun TaskEditorDialogPreview() {
  var task by remember {
    mutableStateOf(TaskEditorModel.DEFAULT_VALUE)
  }

  val stateHolder = object : TaskEditorStateHolder {
    override fun getTask(): Flow<TaskEditorModel> {
      return flow { emit(task) }
    }

    override fun setName(name: String) {
      task = task.copy(name = name)
    }

    override fun setDuration(duration: Long) {
      task = task.copy(duration = duration)
    }

    override fun save() {

    }

  }

  TimeDoserTheme() {
    TaskEditorDialogContent(
      onDismiss = { },
      stateHolder = stateHolder
    )
  }
}