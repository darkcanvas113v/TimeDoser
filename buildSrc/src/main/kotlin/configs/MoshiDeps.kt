package configs

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.moshiDeps() {
  add("implementation", Deps.Moshi.core)
  add("kapt", Deps.Moshi.codegen)
}