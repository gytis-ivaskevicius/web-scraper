package com.gytis.selenium

import com.gytis.scrapper.Scrapper
import com.gytis.scrapper.models.*
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.net.URL

class SeleniumScrapper(private val driver: RemoteWebDriver) : Scrapper {

    private fun getElement(identifier: Identifier): WebElement = try {
        if (identifier.value.isEmpty()) {
            throw IllegalArgumentException()
        }
        when (identifier) {
            { it: Identifier -> it.value.isEmpty() } -> throw IllegalArgumentException()
            is Selector -> driver.findElementByCssSelector(identifier.value)
            is XPath -> driver.findElementByXPath(identifier.value)
            else -> throw OperationNotSupported()
        }
    } catch (_: NoSuchElementException) {
        throw ElementNotFound(identifier.value)
    }

    override fun getText(identifier: Identifier): String {
        return getElement(identifier).text
    }

    override fun getHref(identifier: Identifier): String {
        return getAttribute(identifier, "href")
    }

    override fun getAttribute(identifier: Identifier, attribute: String): String = try {
        getElement(identifier).getAttribute(attribute)
    } catch (e: IllegalStateException) {
        throw IllegalArgumentException(e)
    }

    override fun click(identifier: Identifier) = identifier.also {
        getElement(identifier).click()
    }

    override fun navigate(url: URL) {
        driver.navigate().to(url)
    }
}
