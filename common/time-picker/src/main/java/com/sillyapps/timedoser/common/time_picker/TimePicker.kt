package com.sillyapps.timedoser.common.time_picker

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.sillyapps.core_time.convertToMillis
import com.sillyapps.core_time.formatValue
import com.sillyapps.core_time.getHoursAndMinutes
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.common.lang.R as lang

@Composable
fun TimePickerDialog(
  visible: Boolean,
  onDismiss: () -> Unit,
  time: Long,
  onGetResult: (Long) -> Unit
) {

  val (hours, minutes) = getHoursAndMinutes(time)

  val (mHours, setHours) = remember {
    mutableStateOf(hours)
  }

  val (mMinutes, setMinutes) = remember {
    mutableStateOf(minutes)
  }

  if (visible) {
    Dialog(
      onDismissRequest = onDismiss
    ) {
      Surface(
        shape = MaterialTheme.shapes.small
      ) {
        Column(
          modifier = Modifier
            .padding(vertical = 16.dp)
            .padding(horizontal = 16.dp)
        ) {
          Text(
            text = stringResource(id = R.string.pick_time),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
          )

          TimePicker(
            hours = mHours,
            setHours = setHours,
            minutes = mMinutes,
            setMinutes = setMinutes
          )

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
                onGetResult(convertToMillis(mHours, mMinutes))
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

  }

}

@Composable
fun TimePicker(
  hours: Int,
  setHours: (Int) -> Unit,
  minutes: Int,
  setMinutes: (Int) -> Unit
) {
  val focusManager = LocalFocusManager.current

  Row(
    modifier = Modifier
      .fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    TimePickerItem(
      value = hours,
      setValue = setHours,
      maxValue = 24,
      modifier = Modifier.align(Alignment.CenterVertically),
      keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Number
      ),
      keyboardActions = KeyboardActions(
        onNext = {
          focusManager.moveFocus(FocusDirection.Right)
        }
      )
    )
    Text(
      text = ":",
      style = MaterialTheme.typography.h3,
      modifier = Modifier
        .align(Alignment.CenterVertically)
        .padding(horizontal = 4.dp),

      textAlign = TextAlign.Center
    )
    TimePickerItem(
      value = minutes,
      setValue = setMinutes,
      maxValue = 60,
      modifier = Modifier.align(Alignment.CenterVertically),
      keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Done,
        keyboardType = KeyboardType.Number
      ),
      keyboardActions = KeyboardActions(
        onDone = {
          focusManager.clearFocus()
        }
      )
    )
  }
}

@Composable
private fun TimePickerItem(
  value: Int,
  setValue: (Int) -> Unit,
  maxValue: Int,
  modifier: Modifier = Modifier,
  keyboardOptions: KeyboardOptions,
  keyboardActions: KeyboardActions
) {
  val (typing, setTyping) = remember {
    mutableStateOf(false)
  }

  val (text, setText) = remember {
    mutableStateOf(formatValue(value))
  }

  if (!typing)
    setText(formatValue(value))

  TextField(
    value = text,
    onValueChange = { newText ->
      val typedCharacter = newText.lastOrNull()
      if (typedCharacter != null && !typedCharacter.isDigit()) return@TextField

      val newValue = newText.toIntOrNull()
      if (newValue == null || newValue < maxValue)
        setText(newText)
      else {
        setText(typedCharacter.toString())
      }
    },
    keyboardOptions = keyboardOptions,
    keyboardActions = keyboardActions,
    singleLine = true,
    textStyle = MaterialTheme.typography.h3.copy(textAlign = TextAlign.Center),
    modifier = modifier
      .width(120.dp)
      .wrapContentHeight()
      .onFocusChanged {
        if (it.isFocused) {
          setText("")
          setTyping(true)
        }
        if (!it.isFocused && typing) {
          val newValue = text.toIntOrNull() ?: 0
          setTyping(false)
          setValue(newValue)
        }

      }
  )

}

@Preview
@Composable
fun TimePickerPreview() {
  val (hours, setHours) = remember {
    mutableStateOf(0)
  }
  val (minutes, setMinutes) = remember {
    mutableStateOf(0)
  }
  TimeDoserTheme() {
    Surface() {
      TimePicker(
        hours, setHours, minutes, setMinutes
      )
    }
  }
}

@Preview
@Composable
fun TimePickerDialogPreview() {
  val (dialogVisibility, setDialogVisibility) = remember {
    mutableStateOf(true)
  }

  TimeDoserTheme() {
    Surface() {
      TimePickerDialog(
        onDismiss = { setDialogVisibility(false) },
        visible = dialogVisibility,
        onGetResult = { },
        time = 0L
      )
    }
  }
}