package com.gytis.webscrappper.models

interface Identifier {
    val value: String
}



inline class Selector(override val value: String) : Identifier
inline class XPath(override val value: String) : Identifier

inline class Key(val value: String)


data class WebsiteTarget(
    val target: String,
    val selectors: Map<Key, Identifier>
)
