package com.gytis.selenium

import org.openqa.selenium.remote.RemoteWebDriver
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.net.URL

class SeleniumPool(val selenium: RemoteWebDriver, val scheduler: Scheduler = Schedulers.elastic()) {
    fun get(url: URL): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
