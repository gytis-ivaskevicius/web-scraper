dependencies {
    compileOnly(project(":web-scraper-core"))
    implementation("org.jsoup:jsoup:1.12.1")
    testImplementation("org.mock-server:mockserver-netty:5.8.1")
}
