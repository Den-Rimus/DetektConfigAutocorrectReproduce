
plugins {
   id("com.android.application")
   id("org.jetbrains.kotlin.android")
   id("io.gitlab.arturbosch.detekt")
}

android {
   compileSdk = 32

   defaultConfig {
      applicationId = "io.example.detektautocorrect"
      minSdk = 21
      targetSdk = 32
      versionCode = 1
      versionName = "1.0"
   }

   buildTypes {
      named("release") {
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
   implementation("androidx.core:core-ktx:1.7.0")
   implementation("androidx.appcompat:appcompat:1.4.2")
   implementation("com.google.android.material:material:1.6.1")
   implementation("androidx.constraintlayout:constraintlayout:2.1.4")

   detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.21.0")
}
