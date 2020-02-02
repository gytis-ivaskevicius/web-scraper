package com.gytis.selenium

import com.gytis.scrapper.Scrapper
import com.gytis.scrapper.models.Identifier
import com.gytis.scrapper.models.OperationNotSupported
import com.gytis.scrapper.models.Selector
import com.gytis.scrapper.models.XPath
import com.gytis.selenium.models.Key
import com.gytis.selenium.models.WebsiteTarget
import org.openqa.selenium.By
import org.openqa.selenium.Platform
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class SeleniumScrapper(private val driver: RemoteWebDriver) : Scrapper {

    private fun getElement(identifier: Identifier) = when (identifier) {
        is Selector -> driver.findElementByCssSelector(identifier.value)
        is XPath -> driver.findElementByXPath(identifier.value)
        else -> throw OperationNotSupported()
    }

    override fun getText(identifier: Identifier): String {
        return getElement(identifier).text
    }

    override fun getHref(identifier: Identifier): String {
        return getAttribute(identifier, "href")
    }

    override fun getAttribute(identifier: Identifier, attribute: String): String {
        return getElement(identifier).getAttribute(attribute)
    }

    override fun click(identifier: Identifier) = identifier.also {
        getElement(identifier).click()
    }

    override fun navigate(url: URL) {
        driver.navigate().to(url)
    }
}
