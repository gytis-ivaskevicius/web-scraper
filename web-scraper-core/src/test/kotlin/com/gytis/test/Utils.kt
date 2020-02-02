package com.gytis.test

import com.google.common.io.Files
import com.google.common.io.Resources
import org.mockserver.integration.ClientAndServer
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse
import java.io.File

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun getResourceAsText(path: String): String {
    return object {}.javaClass.classLoader.getResource(path).readText()
}

fun startMockServerWithTestHtml(port: Int): ClientAndServer {
    val html = getResourceAsText("test.html")
    return ClientAndServer.startClientAndServer(port).apply {
        `when`(HttpRequest.request()).respond(HttpResponse.response().withBody(html))
    }
}
