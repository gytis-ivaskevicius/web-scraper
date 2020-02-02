package com.gytis.selenium

import com.gytis.scrapper.external.ScrapperBlock
import com.gytis.scrapper.external.ScrapperConfig
import org.openqa.selenium.remote.RemoteWebDriver
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.net.URL

@Suppress("MemberVisibilityCanBePrivate")
class SeleniumConfig(val selenium: RemoteWebDriver) : ScrapperConfig {

    override fun <T> open(url: URL, block: ScrapperBlock<T>): Mono<T> {
        return Mono.just(url)
            .subscribeOn(Schedulers.elastic())
            .map {
                selenium.navigate().to(url)
                block(SeleniumScrapper(selenium))
            }
    }
}
