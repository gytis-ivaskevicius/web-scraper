package com.gytis.selenium.scrappers

import com.gytis.selenium.models.Key
import com.gytis.selenium.models.WebsiteTarget

interface Scrapper {
    fun run(website: WebsiteTarget): Map<Key, String?>
}
