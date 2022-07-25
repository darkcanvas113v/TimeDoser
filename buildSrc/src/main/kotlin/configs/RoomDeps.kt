package configs

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.roomDeps() {
  add("implementation", Deps.Room.ktx)
  add("implementation", Deps.Room.runtime)
  add("kapt", Deps.Room.annotationProcessor)
  add("testImplementation", Deps.Compose.foundation)
}