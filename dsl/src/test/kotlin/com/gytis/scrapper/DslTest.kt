package com.gytis.scrapper

import com.gytis.scrapper.models.Selector
import io.kotlintest.specs.StringSpec

class DslTest : StringSpec({
    val selector = Selector(".btn")
    val a = scrapper {
        click(selector)
        text(selector)
        get(selector)
    }

})

