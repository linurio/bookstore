//val kotlin_version: String by project
//val logback_version: String by project
//val exposed_version: String by project
//val h2_version: String by project
//val koin_ktor: String by project

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm")
    id("io.ktor.plugin") version "2.3.12"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"
}

application {
    mainClass.set("com.example.api")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

//dependencies {
//    implementation(project(":shared"))
//    implementation("io.ktor:ktor-server-cors-jvm")
//    implementation("io.ktor:ktor-server-netty-jvm")
//    implementation("io.ktor:ktor-server-core-jvm")
//    implementation("io.ktor:ktor-server-auth-jvm")
//    implementation("io.ktor:ktor-server-auth-jwt-jvm")
//    implementation("io.ktor:ktor-server-content-negotiation-jvm")
//    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
//    implementation("io.insert-koin:koin-logger-slf4j:$koin_ktor")
//    implementation("io.insert-koin:koin-ktor:$koin_ktor")
//    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
//    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
//    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
//    implementation("org.jetbrains.exposed:exposed-java-time:$exposed_version")
//    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
//    implementation("ch.qos.logback:logback-classic:$logback_version")
//    implementation("org.postgresql:postgresql:42.7.3")
//}

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
}