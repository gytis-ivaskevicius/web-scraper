dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile("io.projectreactor:reactor-core:3.3.2.RELEASE")

    testImplementation(project(":selenium"))
    testImplementation(project(":jsoup"))

    testImplementation("org.seleniumhq.selenium:selenium-java:3.4.0")
    testImplementation("org.mock-server:mockserver-netty:5.8.1")
}
