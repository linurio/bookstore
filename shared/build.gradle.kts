repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "2.0.0"
    `java-library`
}

dependencies {
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}

