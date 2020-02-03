package com.gytis.jsoupscrapper

import com.gytis.scraper.Scraper
import com.gytis.scraper.models.ElementNotFound
import com.gytis.scraper.models.Identifier
import com.gytis.scraper.models.OperationNotSupported
import com.gytis.scraper.models.Selector
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.lang.IllegalArgumentException
import java.net.URL

class JsoupScraper(private var document: Document, private val jsoupConfig: JsoupConfig) : Scraper {

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
            "href" -> "abs:href"
            else -> attribute
        }
            .let { getElement(identifier).attr(it) }
            .ifEmpty { throw IllegalArgumentException() }

    }

    override fun click(identifier: Identifier): Identifier {
        throw OperationNotSupported()
    }

    override fun navigate(url: URL) {
        document = Jsoup.parse(url, jsoupConfig.timeoutMillis)
    }

}
