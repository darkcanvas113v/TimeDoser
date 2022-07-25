plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("kotlin-kapt")
}

android {
  compileSdk = AndroidSettings.compileSdk

  defaultConfig {
    applicationId = AndroidSettings.applicationId
    minSdk = AndroidSettings.minSdk
    targetSdk = AndroidSettings.targetSdk
    versionCode = AndroidSettings.versionCode
    versionName = AndroidSettings.versionName

    testInstrumentationRunner = AndroidSettings.testInstrumentationRunner
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    isCoreLibraryDesugaringEnabled = true
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = Deps.Compose.COMPILER_VERSION
  }

  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation(project(":core:di"))
  implementation(project(":core:ui"))

  implementation(project(":common:ui"))

  implementation(project(":data:template"))
  implementation(project(":data:day"))

  implementation(project(":domain:template"))
  implementation(project(":domain:day"))

  implementation(project(":features:main-screen"))
  implementation(project(":features:template-list-screen"))
  implementation(project(":features:template-save-screen"))
  implementation(project(":features:task-editor-screen"))
  implementation(project(":features:day-service"))

  coreLibraryDesugaring(Deps.desugaring)

  implementation(Deps.coreKtx)
  implementation(Deps.appCompat)

  // Compose
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

  implementation(Deps.Dagger.core)
  kapt(Deps.Dagger.annotationProcessor)

  // Room
  implementation(Deps.Room.runtime)
  implementation(Deps.Room.ktx)
  kapt(Deps.Room.annotationProcessor)
  testImplementation(Deps.Room.testing)

  implementation(Deps.Moshi.core)
}