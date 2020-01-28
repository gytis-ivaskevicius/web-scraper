import org.jsoup.Jsoup


class HtmlScrapper {

    fun parseWebsite(website: WebsiteTarget): Map<Key, String?> {
        return Jsoup.connect(website.target).get().let { doc ->
            website.selectors.mapValues { entry ->
                doc.select(entry.value.value).firstOrNull()?.text()
            }
        }
    }
}
