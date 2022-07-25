package configs

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.composeDeps() {
  add("implementation", Deps.Compose.runtime)
  add("implementation", Deps.Compose.ui)
  add("implementation", Deps.Compose.uiTooling)
  add("implementation", Deps.Compose.foundation)
  add("implementation", Deps.Compose.foundationLayout)
  add("implementation", Deps.Compose.material)
  add("implementation", Deps.Compose.materialIcons)
  add("implementation", Deps.Compose.materialIconsExtended)
  add("implementation", Deps.Compose.activity)
  add("implementation", Deps.Compose.navigation)
}