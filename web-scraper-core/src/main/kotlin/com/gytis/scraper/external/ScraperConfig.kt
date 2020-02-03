package com.gytis.scraper.external

import com.gytis.scraper.Scraper
import reactor.core.publisher.Mono
import java.net.URL

typealias ScraperBlock<T> = Scraper.() -> T

interface ScraperConfig {

    fun <T> open(url: URL, block: ScraperBlock<T>): Mono<T>
}
