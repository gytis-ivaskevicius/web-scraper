package com.gytis.selenium

import com.gytis.scrapper.external.ScrapperBlock
import com.gytis.scrapper.external.ScrapperConfig
import org.openqa.selenium.Platform
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import reactor.core.Disposable
import reactor.core.publisher.Mono
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.net.URL

@Suppress("MemberVisibilityCanBePrivate")
class SeleniumConfig(val selenium: SeleniumPool) : ScrapperConfig, Disposable {

    override fun <T> open(url: URL, block: ScrapperBlock<T>): Mono<T> {
        val driver = selenium.get(url)
//        selen.navigate().to(url)
//        return Mono.just(url)
//            .subscribeOn(scheduler)
//            .map {
//                val document = Jsoup.parse(url, timeoutMillis)
//                block(JsoupScrapper(document))
//            }
    }

    override fun dispose() {

    }
}
