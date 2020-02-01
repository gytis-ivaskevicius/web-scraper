package com.gytis.scrapper

import com.gytis.scrapper.external.ScrapperBlock
import com.gytis.scrapper.external.ScrapperConfig
import com.gytis.scrapper.models.Selector
import java.net.URL

class ScrapperConfigImpl : ScrapperConfig {
    override fun <T> open(url: URL, block: ScrapperBlock<T>): T {
        return block(ScrapperImpl())
    }
}

class ScrapperImpl() : Scrapper {
    override fun getText(selector: Selector): String {
        return "getText"
    }

    override fun getAttribute(selector: Selector, attribute: String): String {
        return "getAttribute"
    }

    override fun click(selector: Selector): Selector {
        return selector
    }

    override fun navigate(url: URL) {
    }

}
