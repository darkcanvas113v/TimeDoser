package com.sillyapps.timedoser.features.template_screen.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sillyapps.timedoser.common.ui.theme.TimeDoserTheme
import com.sillyapps.timedoser.features.template_screen.R
import com.sillyapps.timedoser.features.template_screen.model.TemplateUIModel
import com.sillyapps.timedoser.features.template_screen.ui.components.TemplateItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
fun TemplateListScreen(
  stateHolder: TemplateListStateHolder,
  onItemClick: (Long) -> Unit,
  onAddButtonClick: () -> Unit
) {

  val templates by remember(stateHolder) {
    stateHolder.getTemplates()
  }.collectAsState(initial = listOf())

  Surface(
    modifier = Modifier.fillMaxSize()
  ) {
    Box {
      if (templates.isEmpty()) EmptyFragment()
      else DefaultFragment(
        templates = templates,
        onItemClick = onItemClick
      )

      FloatingActionButton(
        onClick = onAddButtonClick,
        modifier = Modifier
          .padding(24.dp)
          .align(Alignment.BottomEnd)
      ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
      }
    }

  }

}

@Composable
fun BoxScope.EmptyFragment() {
  Text(
    text = stringResource(id = R.string.no_templates),
    modifier = Modifier
      .padding(top = 16.dp)
      .align(Alignment.Center)
  )
}

@Composable
fun BoxScope.DefaultFragment(
  templates: List<TemplateUIModel>,
  onItemClick: (Long) -> Unit
) {
  LazyColumn(
    contentPadding = PaddingValues(top = 16.dp)
  ) {
    items(items = templates) {
      TemplateItem(model = it, onClick = onItemClick)
    }
  }
}

@Preview
@Composable
fun TemplateListScreenPreview() {
  val templates = remember {
    mutableStateListOf(
      TemplateUIModel(
        id = 0,
        name = "Template 1",
        taskCount = 2,
        totalDuration = "00:50"
      ),
      TemplateUIModel(
        id = 0,
        name = "Template 2",
        taskCount = 2,
        totalDuration = "00:50"
      ),
      TemplateUIModel(
        id = 0,
        name = "Template 3",
        taskCount = 2,
        totalDuration = "00:50"
      ),
    )
  }

  val stateHolder = object : TemplateListStateHolder {
    override fun getTemplates(): Flow<List<TemplateUIModel>> = flow {
      emit(templates)
    }
  }

  TimeDoserTheme {
    TemplateListScreen(
      stateHolder = stateHolder,
      onItemClick = {},
      onAddButtonClick = {}
    )
  }
}