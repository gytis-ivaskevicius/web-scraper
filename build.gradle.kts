import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import info.solidsoft.gradle.pitest.PitestPluginExtension

plugins {
    kotlin("jvm") version "1.3.61"
    id("info.solidsoft.pitest") version "1.4.6"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "info.solidsoft.pitest")
    group = "com.gytis"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.3")
        testImplementation("io.kotlintest:kotlintest-plugins-pitest:3.3.3")
    }
    configure<PitestPluginExtension> {
        testPlugin.set("KotlinTest")    // <-- Telling Pitest that we're using KotlinTest
        targetClasses.set(listOf("com.gytis.jsoupscrapper.*"))
        avoidCallsTo.set(listOf("kotlin.jvm.internal"))
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xinline-classes")
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}

