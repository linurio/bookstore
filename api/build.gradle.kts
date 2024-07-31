repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm")
    alias(libs.plugins.serialization)
    alias(libs.plugins.ktor)
}

application {
    mainClass.set("com.example.api.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.ktor.server.cors.jvm)
    implementation(libs.ktor.server.netty.jvm)
    implementation(libs.ktor.server.core.jvm)
    implementation(libs.ktor.server.auth.jvm)
    implementation(libs.ktor.server.auth.jwt.jvm)
    implementation(libs.ktor.server.content.negotiation.jvm)
    implementation(libs.ktor.serialization.kotlinx.json.jvm)
    implementation(libs.koin.logger.slf4j)
    implementation(libs.koin.ktor)
    implementation(libs.kotlinx.datetime)
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.java.time)
    implementation(libs.exposed.dao)
    implementation(libs.logback.classic)
    implementation(libs.postgresql)
    implementation(libs.dotenv.kotlin)
    implementation(libs.jbcrypt)
}