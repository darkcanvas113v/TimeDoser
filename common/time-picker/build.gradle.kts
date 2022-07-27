import configs.*

plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
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
  implementation(Deps.coreKtx)

  implementation(project(":common:ui"))
  implementation(project(":common:lang"))
  implementation(project(":core:time"))

  implementation(Deps.Compose.runtime)
  implementation(Deps.Compose.ui)
  implementation(Deps.Compose.uiTooling)
  implementation(Deps.Compose.foundation)
  implementation(Deps.Compose.foundationLayout)
  implementation(Deps.Compose.material)
  implementation(Deps.Compose.materialIcons)
  implementation(Deps.Compose.materialIconsExtended)
  implementation(Deps.Compose.activity)
  implementation(Deps.Compose.navigation)

  implementation(Deps.timber)

  androidTestDeps()
}