repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm")
    alias(libs.plugins.serialization)
    `java-library`

}

dependencies {
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}

