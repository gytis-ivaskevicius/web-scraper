
dependencies {
    compileOnly(project(":web-scraper-core"))
    compileOnly("io.projectreactor:reactor-core:3.3.2.RELEASE")

    implementation("org.seleniumhq.selenium:selenium-java:3.4.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
