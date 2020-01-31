package com.gytis.selenium

import com.gytis.selenium.models.Key
import com.gytis.selenium.models.Selector
import com.gytis.selenium.models.WebsiteTarget
import com.gytis.selenium.scrappers.HtmlScrapper
import com.gytis.selenium.scrappers.SeleniumScrapper
import io.kotlintest.data.forall
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

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
