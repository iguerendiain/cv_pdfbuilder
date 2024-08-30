plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.20"
}

group = "nacholab.cv.pdf"
version = "20240829_1"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

val ktor_version: String by project
val openpdf_version: String by project
val logback_version: String by project
val kotlinx_serialization_version: String by project

dependencies {
    testImplementation(kotlin("test"))
//    implementation("com.github.librepdf:openpdf:$openpdf_version")
//    implementation("com.github.librepdf:openpdf-fonts-extra:$openpdf_version")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinx_serialization_version")
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

tasks.test {
    useJUnitPlatform()
}