package com.gytis.scrapper

import com.gytis.scrapper.models.Selector
import io.kotlintest.specs.StringSpec
import java.net.URL

class DslTest : StringSpec({
    val url = URL("https://google.com")
    val selector = Selector(".btn")

    val returnValue = ScrapperConfigImpl().open(url) {
        click(selector)
        getText(selector)
        getAttribute(selector, "href")
        url
    }

    returnValue.protocol
})

