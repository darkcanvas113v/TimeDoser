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
  implementation(Deps.Dagger.core)
  kapt(Deps.Dagger.annotationProcessor)

  implementation(Deps.Coroutines.core)
}