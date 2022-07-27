package configs

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.androidTestDeps() {
  add("testImplementation", Deps.Test.core)
  add("androidTestImplementation", Deps.Test.android)
  add("androidTestImplementation", Deps.Test.espresso)
}

//([^#]*plugins \{\n  id\(\"com.android.library[^#]*dependencies \{[^#]*)\n*(\}[^#]*)