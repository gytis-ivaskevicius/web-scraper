dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.projectreactor:reactor-core:3.3.2.RELEASE")

    testImplementation(project(":selenium"))
    testImplementation(project(":jsoup"))

    testImplementation("org.seleniumhq.selenium:selenium-chrome-driver:3.14.0")
    testImplementation("org.mock-server:mockserver-netty:5.8.1")
}
