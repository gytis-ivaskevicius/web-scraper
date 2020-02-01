dependencies {
    implementation(project(":dsl"))
    implementation("io.projectreactor:reactor-core:3.3.2.RELEASE")
    implementation("org.jsoup:jsoup:1.12.1")
    testImplementation("org.mock-server:mockserver-netty:5.8.1")
}
