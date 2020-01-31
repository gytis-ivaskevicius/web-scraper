import org.jetbrains.kotlin.gradle.tasks.KotlinCompile;

plugins {
    kotlin("jvm") version "1.3.61"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    group = "com.gytis"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.3")
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

