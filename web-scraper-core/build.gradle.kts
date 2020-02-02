dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile("io.projectreactor:reactor-core:3.3.2.RELEASE")

    testCompile("org.seleniumhq.selenium:selenium-java:3.4.0")
    testCompile("org.mock-server:mockserver-netty:5.8.1")
    implementation(project(":selenium"))
    testCompile(project(":jsoup"))
    testCompile(project(":dsl"))
}
