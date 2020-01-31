package com.gytis.selenium.scrappers

import com.gytis.selenium.models.Key
import com.gytis.selenium.models.WebsiteTarget
import org.openqa.selenium.By
import org.openqa.selenium.Platform
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class SeleniumScrapper : Scrapper {

    override fun run(website: WebsiteTarget): Map<Key, String?> {
        println("Execute")
        val driver = DesiredCapabilities.chrome().apply {
            platform = Platform.LINUX
        }.let { RemoteWebDriver(URL("http://localhost:4444/wd/hub"), it) }
        driver.navigate().to(website.target)
        val sel = website.selectors.mapValues {
            driver.findElement(By.cssSelector(it.value.value)).text
//            driver.findElementByCssSelector(it.value.value).text
        }
        println("end")
        driver.quit()
        return sel
    }
}
