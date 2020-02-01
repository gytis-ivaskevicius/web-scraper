package com.gytis.scrapper

import com.gytis.scrapper.models.Identifier
import io.kotlintest.specs.StringSpec
import java.net.URL

class DslTest : StringSpec({
    val url = URL("https://google.com")
    val selector = Identifier(".btn")

    val returnValue = ScrapperConfigImpl().open(url) {
        click(selector)
        getText(selector)
        getAttribute(selector, "href")
        url
    }

    returnValue.protocol
})

