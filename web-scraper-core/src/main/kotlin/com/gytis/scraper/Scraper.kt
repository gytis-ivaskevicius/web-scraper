package com.gytis.scraper

import com.gytis.scraper.models.Identifier
import java.net.URL

interface Scraper {
    fun getText(identifier: Identifier): String
    fun getHref(identifier: Identifier): String
    fun getAttribute(identifier: Identifier, attribute: String): String

    fun click(identifier: Identifier): Identifier
    fun navigate(url: URL)
}
