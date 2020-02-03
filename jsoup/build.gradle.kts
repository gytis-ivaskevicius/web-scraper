plugins {
    kotlin("jvm")
}

dependencies {
    implementation(platform(project(":bom")))
    compileOnly(project(":web-scraper-core"))
    compileOnly("io.projectreactor:reactor-core")

    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jsoup:jsoup")
}
