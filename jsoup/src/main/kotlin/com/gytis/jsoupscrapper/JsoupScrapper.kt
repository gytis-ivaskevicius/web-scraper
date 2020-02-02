package com.gytis.jsoupscrapper

import com.gytis.scrapper.Scrapper
import com.gytis.scrapper.models.ElementNotFound
import com.gytis.scrapper.models.Identifier
import com.gytis.scrapper.models.OperationNotSupported
import com.gytis.scrapper.models.Selector
import org.jsoup.nodes.Document
import java.lang.IllegalArgumentException
import java.net.URL

class JsoupScrapper(private val document: Document) : Scrapper {

    private fun getElement(identifier: Identifier) = when (identifier) {
        is Selector -> document.selectFirst(identifier.value)
        else -> throw OperationNotSupported("Currently Jsoup only supports css selectors")
    } ?: throw ElementNotFound(identifier.value)

    override fun getText(identifier: Identifier): String {
        return getElement(identifier).text()
    }

    override fun getHref(identifier: Identifier): String {
        return getAttribute(identifier, "abs:href")
    }

    override fun getAttribute(identifier: Identifier, attribute: String): String {
        return when (attribute.toLowerCase()) {
            "href" -> "abs:$attribute"
            else -> attribute
        }
            .let { getElement(identifier).attr(it) }
            .ifEmpty { throw IllegalArgumentException() }

    }

    override fun click(identifier: Identifier): Identifier {
        throw OperationNotSupported()
    }

    override fun navigate(url: URL) {
        throw OperationNotSupported()
    }

}
