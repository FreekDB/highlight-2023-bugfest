import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.serialization") version "1.7.20"
}

group = "com.github.freekdb.kotlin.processing"
version = "0.0.6-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(fileTree("/home/freek/programs/processing-3.5.4/core/library"))
    implementation(files("/home/freek/programs/processing-3.5.4/modes/java/libraries/pdf/library/pdf.jar"))
    implementation(files("/home/freek/programs/processing-3.5.4/modes/java/libraries/pdf/library/itext.jar"))
    implementation("org.reflections:reflections:0.10.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

    val slf4jVersion = "2.0.3"
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
