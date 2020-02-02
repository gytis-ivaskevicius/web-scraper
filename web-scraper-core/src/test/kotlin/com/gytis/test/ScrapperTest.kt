package com.gytis.test

import com.gytis.jsoupscrapper.JsoupConfig
import com.gytis.scrapper.models.ElementNotFound
import com.gytis.scrapper.models.Selector
import com.gytis.selenium.SeleniumConfig
import io.kotlintest.Spec
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import org.openqa.selenium.chrome.ChromeDriver
import java.net.URL


@Suppress("BlockingMethodInNonBlockingContext", "PrivatePropertyName")
class ScrapperTest : StringSpec() {
    private val website = URL("http://localhost:1080")
    private val mockServer = startMockServerWithTestHtml(1080)

    private val P = Selector("p")
    private val A = Selector("a")
    private val DIV = Selector("div")

    init {
        forall(
            row(SeleniumConfig(ChromeDriver())),
            row(JsoupConfig())
        ) { scraperConfig ->

            "${scraperConfig::class.simpleName}: Positive test"{
                scraperConfig.open(website) {
                    val text = getText(P)
                    val href = getAttribute(A, "href")
                    val something = getAttribute(DIV, "something")
                    val url = getHref(A)

                    text shouldBe "Hello World"
                    something shouldBe "something"
                    href shouldBe "http://localhost:1080/test.html"
                    url shouldBe "http://localhost:1080/test.html"
                }.block()
            }

            "${scraperConfig::class.simpleName}: Scrapper throws ${ElementNotFound::class.simpleName} exception"{
                val selector = Selector("bad selector")
                scraperConfig.open(website) {
                    shouldThrow<ElementNotFound> { getText(selector) }
                    shouldThrow<ElementNotFound> { getAttribute(selector, "href") }
                    shouldThrow<ElementNotFound> { getHref(selector) }
                }.block()
            }

            "${scraperConfig::class.simpleName}: Scrapper throws ${IllegalArgumentException::class.simpleName}exception" {
                val selector = Selector("")
                scraperConfig.open(website) {
                    shouldThrow<IllegalArgumentException> { getText(selector) }
                    shouldThrow<IllegalArgumentException> { getAttribute(selector, "test") }
                    shouldThrow<IllegalArgumentException> { getAttribute(DIV, "something2") }
                    shouldThrow<IllegalArgumentException> { getHref(selector) }
                }.block()
            }
        }
    }

    override fun afterSpec(spec: Spec) {
        super.afterSpec(spec)
        mockServer.close()
    }

}
