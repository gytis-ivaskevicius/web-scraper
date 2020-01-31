plugins {
    kotlin("jvm") version "1.3.61"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.seleniumhq.old:old-java:3.141.59")
    implementation("org.seleniumhq.old:old-api:3.141.59")
    implementation("org.seleniumhq.old:old-chrome-driver:3.141.59")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jsoup:jsoup:1.12.1")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
