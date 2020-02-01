package com.gytis.scrapper

import com.gytis.scrapper.external.ScrapperBlock
import com.gytis.scrapper.external.ScrapperConfig
import com.gytis.scrapper.models.Identifier
import reactor.core.publisher.Mono
import java.net.URL

class ScrapperConfigImpl : ScrapperConfig {
    override fun <T> open(url: URL, block: ScrapperBlock<T>): Mono<T> {
        return Mono.just(block(ScrapperImpl()))
    }
}

class ScrapperImpl() : Scrapper {
    override fun getText(identifier: Identifier): String {
        return "getText"
    }

    override fun getHref(identifier: Identifier): String {
        return "getHref"
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
