package configs

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.daggerDeps() {
  add("implementation", Deps.Dagger.core)
  add("kapt", Deps.Dagger.annotationProcessor)
}