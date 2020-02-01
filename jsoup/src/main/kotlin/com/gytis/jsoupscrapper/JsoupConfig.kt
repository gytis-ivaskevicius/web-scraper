package com.gytis.jsoupscrapper

import com.gytis.scrapper.external.ScrapperBlock
import com.gytis.scrapper.external.ScrapperConfig
import org.jsoup.Jsoup
import reactor.core.publisher.Mono
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.net.URL

@Suppress("MemberVisibilityCanBePrivate")
class JsoupConfig(val timeoutMillis: Int = 5000, val scheduler: Scheduler = Schedulers.elastic()) : ScrapperConfig {

    override fun <T> open(url: URL, block: ScrapperBlock<T>): Mono<T> {
        return Mono.just(url)
            .subscribeOn(scheduler)
            .map {
                val document = Jsoup.parse(url, timeoutMillis)
                block(JsoupScrapper(document))
            }
    }
}
