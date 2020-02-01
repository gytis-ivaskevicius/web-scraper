package com.gytis.scrapper.models

import com.gytis.scrapper.Scrapper
import java.net.URL

typealias ScrapperBlock<T> = Scrapper.() -> T

interface ScrapperConfig {

    fun <T> scrapper(url: URL, block: ScrapperBlock<T>): T {
        return block(Scrapper())
    }
}
