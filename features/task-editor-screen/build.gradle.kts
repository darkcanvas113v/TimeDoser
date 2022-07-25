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

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = Deps.Compose.COMPILER_VERSION
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
  implementation(project(":core:di"))
  implementation(project(":core:ui"))
  implementation(project(":core:time"))
  implementation(project(":core:util"))

  implementation(project(":common:ui"))
  implementation(project(":common:lang"))
  implementation(project(":common:time-picker"))

  implementation(project(":domain:day"))

  implementation(Deps.coreKtx)
  implementation(Deps.appCompat)

  composeDeps()
  daggerDeps()
}