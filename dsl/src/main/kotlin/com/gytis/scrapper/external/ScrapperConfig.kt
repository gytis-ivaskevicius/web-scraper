package com.gytis.scrapper.external

import com.gytis.scrapper.Scrapper
import reactor.core.publisher.Mono
import java.net.URL

typealias ScrapperBlock<T> = Scrapper.() -> T

interface ScrapperConfig {

    fun <T> open(url: URL, block: ScrapperBlock<T>): Mono<T>
}
