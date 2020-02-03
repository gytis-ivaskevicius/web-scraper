package com.gytis.selenium

import com.gytis.scraper.external.ScraperBlock
import com.gytis.scraper.external.ScraperConfig
import org.openqa.selenium.remote.RemoteWebDriver
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.net.URL

@Suppress("MemberVisibilityCanBePrivate")
class SeleniumConfig(val selenium: RemoteWebDriver) : ScraperConfig {

    override fun <T> open(url: URL, block: ScraperBlock<T>): Mono<T> {
        return Mono.just(url)
            .subscribeOn(Schedulers.elastic())
            .map {
                selenium.navigate().to(url)
                block(SeleniumScraper(selenium))
            }
    }
}
