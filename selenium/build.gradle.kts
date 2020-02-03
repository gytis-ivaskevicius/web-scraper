
dependencies {
    compileOnly(project(":web-scraper-core"))
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:3.14.0")
    implementation("org.seleniumhq.selenium:selenium-api:3.14.0")
    implementation("org.seleniumhq.selenium:selenium-java:3.4.0")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
