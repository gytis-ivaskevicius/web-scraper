package com.gytis.scrapper

import com.gytis.scrapper.models.Selector
import java.net.URL

interface Scrapper {
    fun getText(selector: Selector): String
    fun getAttribute(selector: Selector, attribute: String): String

    fun click(selector: Selector): Selector
    fun navigate(url: URL)
}
