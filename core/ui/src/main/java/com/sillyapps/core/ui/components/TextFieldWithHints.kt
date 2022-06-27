package com.sillyapps.core.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.exp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TextFieldWithHints(
  items: List<String>,
  label: String
) {
  
  val (text, setText) = remember {
    mutableStateOf("")
  }

  var expanded by remember {
    mutableStateOf(false)
  }
  
  val filteredItems = items.filter { it.startsWith(text) }

  ExposedDropdownMenuBox(
    expanded = expanded,
    onExpandedChange = { expanded = !expanded }) {

    TextField(
      value = text,
      onValueChange = setText,
      label = { Text(text = label) },
      trailingIcon = {
        ExposedDropdownMenuDefaults.TrailingIcon(
          expanded = expanded
        )
      },
      singleLine = true
    )

    ExposedDropdownMenu(
      expanded = expanded,
      onDismissRequest = { expanded = false }) {
      filteredItems.forEach() {
        DropdownMenuItem(
          onClick = { setText(it) }
        ) {
          Text(text = it)
        }
      }
    }
  }
}

@Preview
@Composable
fun TextFieldWithHintsPreview() {
  val items = listOf(
    "Template 1",
    "Template 2",
    "Template 3"
  )

  TextFieldWithHints(
    items = items,
    label = "Name"
  )
}