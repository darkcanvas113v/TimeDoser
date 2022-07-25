object BuildPlugins {

  // You should manually set this dependencies in buildSrc/build.gradle.kts as they're not visible there
  const val KOTLIN_VERSION = "1.7.0"
  const val GRADLE_VERSION = "7.2.1"

  const val gradle = "com.android.tools.build:gradle:$GRADLE_VERSION"
  const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${KOTLIN_VERSION}"
}