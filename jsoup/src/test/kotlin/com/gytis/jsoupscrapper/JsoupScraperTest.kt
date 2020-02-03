package com.gytis.jsoupscrapper

import com.google.common.io.Files
import com.gytis.scraper.models.ElementNotFound
import com.gytis.scraper.models.OperationNotSupported
import com.gytis.scraper.models.Selector
import io.kotlintest.Spec
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import org.mockserver.integration.ClientAndServer.startClientAndServer
import org.mockserver.model.HttpRequest.request
import org.mockserver.model.HttpResponse.response
import java.io.File
import java.net.URL


@Suppress("BlockingMethodInNonBlockingContext")
class JsoupScraperTest : StringSpec() {
    val website = URL("http://localhost:1080")
    var html = Files.asCharSource(File(javaClass.classLoader.getResource("test.html").toURI()), Charsets.UTF_8).read()
    val mockServer = startClientAndServer(1080).apply {
        `when`(request()).respond(response().withBody(html))
    }

    init {
        val jsoup = JsoupConfig()

        "Jsoup positive test"{
            jsoup.open(website) {
                val text = getText(Selector("p"))
                val href = getAttribute(Selector("a"), "href")
                val url = getHref(Selector("a"))

                text shouldBe "Hello World"
                href shouldBe "test.html"
                url shouldBe "http://localhost:1080/test.html"
            }.block()
        }

        "Scrapper throws ${OperationNotSupported::class.simpleName} exception"{
            val selector = Selector("bad selector")
            jsoup.open(website) {
                shouldThrow<OperationNotSupported> {
                    navigate(URL("https://localhost:1080/somewhere"))
                }
                shouldThrow<OperationNotSupported> {
                    click(selector)
                }
            }.block()
        }

        "Scrapper throws ${ElementNotFound::class.simpleName} exception"{
            val selector = Selector("bad selector")
            jsoup.open(website) {
                shouldThrow<ElementNotFound> {
                    getText(selector)
                }
                shouldThrow<ElementNotFound> {
                    getAttribute(selector, "href")
                }
                shouldThrow<ElementNotFound> {
                    getHref(selector)
                }
            }.block()
        }

        "Scrapper throws ${IllegalArgumentException::class.simpleName}exception" {
            val selector = Selector("")
            shouldThrow<IllegalArgumentException> {
                jsoup.open(website) {
                    getText(selector)
                    getAttribute(selector, "href")
                }.block()
            }
        }
    }

    override fun afterSpec(spec: Spec) {
        super.afterSpec(spec)
        mockServer.close()
    }

}
