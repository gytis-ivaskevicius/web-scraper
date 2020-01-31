package com.gytis.webscrappper.scrappers

import com.gytis.webscrappper.models.Key
import com.gytis.webscrappper.models.WebsiteTarget

interface Scrapper {
    fun run(website: WebsiteTarget): Map<Key, String?>
}
