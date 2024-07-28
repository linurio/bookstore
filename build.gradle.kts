repositories {
    google()
    mavenCentral()
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    kotlin("jvm") version "2.0.0"
}