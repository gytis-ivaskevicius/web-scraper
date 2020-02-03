package com.gytis.scraper.models

import java.lang.Exception

class OperationNotSupported(msg: String = "Operation not supported") : Exception(msg)

class ElementNotFound(element: String?) :
    Exception(if (element.isNullOrBlank()) "Element not found" else "Element '$element' not found")
