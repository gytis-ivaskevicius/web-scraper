package com.gytis.scrapper.models

import java.lang.Exception

class OperationNotSupported(private val msg: String = "Operation not supported") : Exception(msg)

class ElementNotFound(private val element: String?) :
    Exception(if (element.isNullOrBlank()) "Element not found" else "Element '$element' not found")
