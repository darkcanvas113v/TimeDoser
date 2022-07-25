object Deps {

  const val appCompat = "androidx.appcompat:appcompat-resources:1.4.2"
  const val coreKtx = "androidx.core:core-ktx:1.8.0"

  const val desugaring = "com.android.tools:desugar_jdk_libs:1.1.5"

  const val timber = "com.jakewharton.timber:timber:4.7.1"

  object Junit {
    const val core = "junit:junit:4.13.2"
    const val android = "androidx.test.ext:junit:1.1.3"
    const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
  }

  object Lifecycle {
    private const val VERSION = "2.5.0"

    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$VERSION"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION"
    const val annotationProcessor = "androidx.lifecycle:lifecycle-compiler:$VERSION"
  }

  object Dagger {
    private const val VERSION = "2.43"

    const val core = "com.google.dagger:dagger:$VERSION"
    const val annotationProcessor = "com.google.dagger:dagger-compiler:$VERSION"
  }

  object Room {
    private const val VERSION = "2.4.2"

    const val runtime = "androidx.room:room-runtime:$VERSION"
    const val ktx = "androidx.room:room-ktx:$VERSION"
    const val annotationProcessor = "androidx.room:room-compiler:$VERSION"
    const val testing = "androidx.room:room-testing:$VERSION"
  }

  object Coroutines {
    private const val VERSION = "1.6.4"

    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
  }

  object Moshi {
    private const val VERSION = "1.13.0"

    const val core = "com.squareup.moshi:moshi:$VERSION"
    const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$VERSION"
  }

  object Retrofit {
    private const val VERSION = "2.9.0"

    const val core = "com.squareup.retrofit2:retrofit:$VERSION"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$VERSION"
  }

  object OkHttp {
    private const val VERSION = "4.9.3"

    const val core = "com.squareup.okhttp3:okhttp:$VERSION"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$VERSION"
  }

  object Compose {
    const val VERSION = "1.2.0-rc02"
    const val COMPILER_VERSION = "1.2.0"

    const val runtime = "androidx.compose.runtime:runtime:$VERSION"
    const val ui = "androidx.compose.ui:ui:$VERSION"
    const val uiTooling = "androidx.compose.ui:ui-tooling:$VERSION"
    const val foundation = "androidx.compose.foundation:foundation:$VERSION"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:$VERSION"
    const val material = "androidx.compose.material:material:$VERSION"
    const val materialIcons = "androidx.compose.material:material-icons-core:$VERSION"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$VERSION"
    const val activity = "androidx.activity:activity-compose:1.5.0"
    const val testing = "androidx.compose.ui:ui-test-junit4:$VERSION"
    const val navigation = "androidx.navigation:navigation-compose:2.5.0"
  }

}