buildscript {
  repositories {
    google()
    mavenCentral()
  }

  dependencies {
    classpath(BuildPlugins.gradle)
    classpath(BuildPlugins.kotlin)
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
  }
}