package com.gytis.scrapper

typealias ScrapperBlock<T> = Scrapper.() -> T

fun <T> scrapper(block: ScrapperBlock<T>):T {
    return block(Scrapper())
}
