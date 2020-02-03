plugins {
    kotlin("jvm")
}

dependencies {
    implementation(platform(project(":bom")))
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.projectreactor:reactor-core")

    testImplementation(project(":selenium"))
    testImplementation(project(":jsoup"))

    testImplementation("org.seleniumhq.selenium:selenium-chrome-driver")
    testImplementation("org.mock-server:mockserver-netty")
    testImplementation("io.kotlintest:kotlintest-runner-junit5")
}
