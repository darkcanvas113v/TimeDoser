import configs.*

plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("kotlin-kapt")
}

android {
  compileSdk = AndroidSettings.compileSdk

  defaultConfig {
    minSdk = AndroidSettings.minSdk
    targetSdk = AndroidSettings.targetSdk

    testInstrumentationRunner = AndroidSettings.testInstrumentationRunner
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation(project(":domain:template"))
  implementation(project(":core:di"))

  implementation(Deps.coreKtx)

  roomDeps()
  daggerDeps()
  moshiDeps()

  implementation(Deps.Coroutines.core)
  implementation(Deps.Coroutines.android)
}