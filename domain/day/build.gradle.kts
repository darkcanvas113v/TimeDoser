import configs.*

plugins {
  id("java-library")
  id("org.jetbrains.kotlin.jvm")
  id("kotlin-kapt")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
  implementation(project(":core:util"))
  implementation(project(":core:di"))
  implementation(project(":core:time"))

  daggerDeps()

  implementation(Deps.Coroutines.core)

  testImplementation(Deps.Test.core)
  testImplementation(Deps.Test.truth)

  implementation(Deps.timber)
}