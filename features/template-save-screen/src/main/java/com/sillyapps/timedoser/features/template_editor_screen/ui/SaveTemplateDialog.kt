package com.sillyapps.timedoser.features.template_editor_screen.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.features.template_editor_screen.R
import com.sillyapps.timedoser.common.lang.R as lang
import com.sillyapps.timedoser.features.template_editor_screen.model.TemplateInfo

@Composable
internal fun SaveTemplateDialogInternal(
  onDismiss: () -> Unit,
  stateHolder: SaveTemplateDialogStateHolder
) {
  Dialog(
    onDismissRequest = onDismiss
  ) {
    SaveTemplateDialogContent(
      onDismiss = onDismiss,
      stateHolder = stateHolder
    )
  }
}

@Composable
internal fun SaveTemplateDialogContent(
  onDismiss: () -> Unit,
  stateHolder: SaveTemplateDialogStateHolder
) {
  var templateInfo by remember {
    mutableStateOf(TemplateInfo(""))
  }

  Surface(
    modifier = Modifier
      .clip(MaterialTheme.shapes.small)
  ) {
    Column(
      modifier = Modifier
        .padding(vertical = 16.dp)
        .padding(horizontal = 12.dp)
        .width(IntrinsicSize.Min)
    ) {
      Text(
        text = stringResource(id = R.string.save_template),
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(bottom = 16.dp)
      )



      OutlinedTextField(
        value = templateInfo.name,
        onValueChange = {
          templateInfo = templateInfo.copy(name = it)
        },
        label = { Text(text = stringResource(id = lang.string.name)) }
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
          onClick = {  },
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
internal fun SaveTemplateDialogPreview() {
  val stateHolder = object : SaveTemplateDialogStateHolder {

  }

  TimeDoserTheme {
    SaveTemplateDialogContent(
      onDismiss = {},
      stateHolder = stateHolder
    )
  }
}