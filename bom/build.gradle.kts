plugins {
    `java-platform`
}

javaPlatform {
    allowDependencies()
}

dependencies {
    constraints {
        api("io.projectreactor:reactor-core:3.3.2.RELEASE")
        api("org.jsoup:jsoup:1.12.1")
        api("org.seleniumhq.selenium:selenium-java:3.141.59")
        api("org.seleniumhq.selenium:selenium-chrome-driver:3.141.59")
        api("org.mock-server:mockserver-netty:5.9.0")
        api("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    }
}
