package com.sillyapps.timedoser.domain

sealed class DataState<out T>() {

  class Loading<T>: DataState<T>()

  class Success<out T>(val data: T): DataState<T>()

  class Empty<T>: DataState<T>()

  class Error<T>(val message: String): DataState<T>()

}