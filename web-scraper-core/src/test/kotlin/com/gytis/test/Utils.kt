package com.gytis.test

import org.mockserver.integration.ClientAndServer
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun getResourceAsText(path: String): String {
    return object {}.javaClass.classLoader.getResource(path).readText()
}

fun startMockServerWithTestHtml(port: Int): ClientAndServer {
    val testHtml = getResourceAsText("test.html")
    val test2Html = getResourceAsText("test2.html")
    return ClientAndServer.startClientAndServer(port).apply {
        `when`(HttpRequest.request().withPath("/")).respond(HttpResponse.response().withBody(testHtml))
        `when`(HttpRequest.request().withPath("/test2.html")).respond(HttpResponse.response().withBody(test2Html))
    }
}
