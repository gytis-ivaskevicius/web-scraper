package com.gytis.scraper.models


interface Identifier {
    val value: String
}

inline class Selector(override val value: String) : Identifier
inline class XPath(override val value: String) : Identifier

