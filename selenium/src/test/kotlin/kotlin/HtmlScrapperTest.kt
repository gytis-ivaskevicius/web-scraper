import com.gytis.webscrappper.models.Key
import com.gytis.webscrappper.models.Selector
import com.gytis.webscrappper.models.WebsiteTarget
import com.gytis.webscrappper.scrappers.HtmlScrapper
import com.gytis.webscrappper.scrappers.SeleniumScrapper
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.shouldNot
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import java.util.ArrayList

class HtmlScrapperTest : StringSpec({
    forall(
        row(HtmlScrapper()),
        row(SeleniumScrapper())
    ) { scrapper ->

        println("test")
        "Executing ${scrapper::class.simpleName}"{

            val input = mapOf(
                Key("lietuva") to Selector(".Q8LRLc"),
                Key("reklamavimas") to Selector("#fsl > a:nth-child(1)"),
                Key("verslas") to Selector("#fsl > a:nth-child(2)"),
                Key("apie") to Selector("#fsl > a:nth-child(3)"),
                Key("kaip_veikia") to Selector("#fsl > a:nth-child(4)")
            )
            val website = WebsiteTarget("https://google.com/", input)
            val output = scrapper.run(website)
        }
    }

})
