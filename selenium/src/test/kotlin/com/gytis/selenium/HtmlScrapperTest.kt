package com.gytis.selenium

import io.kotlintest.specs.StringSpec
import org.openqa.selenium.Platform
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class HtmlScrapperTest : StringSpec({
    DesiredCapabilities.chrome().apply {
        platform = Platform.LINUX
    }.let { RemoteWebDriver(URL("http://localhost:4444/wd/hub"), it) }
})
