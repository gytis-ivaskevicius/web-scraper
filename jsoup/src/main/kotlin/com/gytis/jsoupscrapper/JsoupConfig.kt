package com.gytis.jsoupscrapper

import com.gytis.scraper.external.ScraperBlock
import com.gytis.scraper.external.ScraperConfig
import org.jsoup.Jsoup
import reactor.core.publisher.Mono
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.net.URL

@Suppress("MemberVisibilityCanBePrivate")
class JsoupConfig(val timeoutMillis: Int = 10000, val scheduler: Scheduler = Schedulers.elastic()) : ScraperConfig {

    override fun <T> open(url: URL, block: ScraperBlock<T>): Mono<T> {
        return Mono.just(url)
            .subscribeOn(scheduler)
            .map {
                val document = Jsoup.parse(url, timeoutMillis)
                block(JsoupScraper(document, this))
            }
    }
}
