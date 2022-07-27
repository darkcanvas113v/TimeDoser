package com.sillyapps.timedoser.domain.day.logic

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

data class Model(
  var name: String,
  var items: List<String>
)

class TestCoroutinesFlow {

  @Test
  fun test_flowBuilder() {
    val model = Model("k", ('a'..'z').map { it.toString() })

    val observable = flow {
      emit(model)
      delay(2000L)
      model.name = "zz"
      emit(model)
    }

    runBlocking {
      observable.collect {
        println(it.name)
      }
    }
  }

  @Test
  fun test_SharedFlow() {
    val model = Model("k", ('a'..'z').map { it.toString() })

    val observable = MutableSharedFlow<Model>()
  }



}