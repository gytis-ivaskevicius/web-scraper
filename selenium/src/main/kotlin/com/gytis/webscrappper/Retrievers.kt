package com.gytis.webscrappper

import com.gytis.webscrappper.models.IncorrectArguments
import org.jsoup.nodes.Element

typealias  Retriever = (el: Element, params: List<String>) -> String

enum class Retrievers(retriever: Retriever) {
    TEXT({ el, _ -> el.text() }),
    ATTRIBUTE({ el, params ->
        params.firstOrNull()?.let { el.attr(it) } ?: throw  IncorrectArguments("attribute_name")
    })
    ;
}
