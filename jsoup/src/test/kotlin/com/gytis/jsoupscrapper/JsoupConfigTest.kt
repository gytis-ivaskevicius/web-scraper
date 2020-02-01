package com.gytis.jsoupscrapper

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import reactor.core.scheduler.Schedulers


class JsoupConfigTest: StringSpec({
   val jsoup = JsoupConfig()

   "Config defaults check"{
      jsoup.timeoutMillis shouldBe 5000
      jsoup.scheduler shouldBe Schedulers.elastic()
   }
})
