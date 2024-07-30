repositories {
    google()
    mavenCentral()
}

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("kapt") version "2.0.0" apply false

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
}