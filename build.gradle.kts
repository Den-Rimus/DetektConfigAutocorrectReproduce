// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
   id("com.android.application") version "7.2.1" apply false
   id("com.android.library") version "7.2.1" apply false
   id("org.jetbrains.kotlin.android") version "1.6.21" apply false
   id("io.gitlab.arturbosch.detekt") version "1.21.0"
}

tasks.register(name = "clean", type = Delete::class) {
   delete(rootProject.buildDir)
}

detekt {
   config = files("config/detekt/custom_detekt.yml")
   autoCorrect = true
}

allprojects {
   tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
      doFirst { delete(File(buildDir, "reports/detekt")) }

      this.jvmTarget = "1.8"

      reports {
         xml.required.set(false)
         md.required.set(false)
         sarif.required.set(false)
      }
   }
}