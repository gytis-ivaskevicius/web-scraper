import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class HtmlScrapperTest : StringSpec({
    val htmlScrapper = HtmlScrapper()
    "Google.com"{
        forall(
            row(Key("button"), Selector(".Q8LRLc"), "Lietuva")
        ) { key, selector, result ->
            val website = WebsiteTarget("https://google.com/", mapOf(key to selector))
            val output = htmlScrapper.parseWebsite(website)
            val expectedOutput = mapOf(key to result)
            output shouldBe expectedOutput
        }
    }
})
