package com.gytis.selenium.scrappers

import com.gytis.selenium.models.Key
import com.gytis.selenium.models.WebsiteTarget
import org.jsoup.Jsoup


class HtmlScrapper : Scrapper {

    override fun run(website: WebsiteTarget): Map<Key, String?> {
        return Jsoup.connect(website.target).get().let { doc ->
            website.selectors.mapValues { entry ->
                doc.select(entry.value.value).firstOrNull()?.text()
            }
        }
    }
}
