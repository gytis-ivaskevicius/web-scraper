package com.gytis.scrapper

import com.gytis.scrapper.models.Element
import com.gytis.scrapper.models.Selector

class Scrapper {
    fun click(selector: Selector) = selector.also {

    }

    fun text(selector: Selector): String {

        return ""
    }

    fun get(selector: Selector): Element? {
        return null
    }
}
