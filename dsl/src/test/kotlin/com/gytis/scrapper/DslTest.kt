package com.gytis.scrapper

import com.gytis.scrapper.models.Identifier
import com.gytis.scrapper.models.Selector
import com.gytis.scrapper.models.XPath
import io.kotlintest.specs.StringSpec
import java.net.URL

class DslTest : StringSpec({
    val url = URL("https://google.com")
    val selector = Selector(".btn")
    val xpath = XPath("/child::A")

    val returnValue = ScrapperConfigImpl().open(url) {
        navigate(url)

        click(selector)
        getText(selector)
        getAttribute(selector, "href")
        getHref(selector)

        click(xpath)
        getText(xpath)
        getAttribute(xpath, "href")
        getHref(xpath)

        url
    }.block()

    returnValue.protocol
})

