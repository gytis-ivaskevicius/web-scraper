
dependencies {
    compileOnly(project(":web-scraper-core"))
    compileOnly("io.projectreactor:reactor-core:3.3.2.RELEASE")
    implementation("org.jsoup:jsoup:1.12.1")
}
