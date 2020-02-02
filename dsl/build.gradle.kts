dependencies {
    compile("io.projectreactor:reactor-core:3.3.2.RELEASE")
    testCompile(project(":selenium"))
    testCompile("org.mock-server:mockserver-netty:5.8.1")
    testImplementation(project(":jsoup"))
}

