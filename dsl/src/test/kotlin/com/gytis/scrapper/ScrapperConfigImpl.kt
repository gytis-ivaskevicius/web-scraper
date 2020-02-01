package com.gytis.scrapper

import com.gytis.scrapper.external.ScrapperBlock
import com.gytis.scrapper.external.ScrapperConfig
import com.gytis.scrapper.models.Identifier
import java.net.URL

class ScrapperConfigImpl : ScrapperConfig {
    override fun <T> open(url: URL, block: ScrapperBlock<T>): T {
        return block(ScrapperImpl())
    }
}

class ScrapperImpl() : Scrapper {
    override fun getText(identifier: Identifier): String {
        return "getText"
    }

    override fun getAttribute(identifier: Identifier, attribute: String): String {
        return "getAttribute"
    }

    override fun click(identifier: Identifier): Identifier {
        return identifier
    }

    override fun navigate(url: URL) {
    }

}
