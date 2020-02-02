package com.gytis.scrapper

import com.gytis.scrapper.models.Identifier
import java.net.URL

interface Scrapper {
    fun getText(identifier: Identifier): String
    fun getHref(identifier: Identifier): String
    fun getAttribute(identifier: Identifier, attribute: String): String

    fun click(identifier: Identifier): Identifier
    fun navigate(url: URL)
}
