package com.unison.api.client

import java.net.HttpURLConnection

import com.google.mockwebserver.{MockResponse, MockWebServer}
import org.scalatest.{Suite, SuiteMixin}

trait WebServerMock extends SuiteMixin { this: Suite =>
  private[this] var _webServer:MockWebServer = _

  val port = WebServerMock.randomPort
  final def webServer:MockWebServer = _webServer
  final def webServerUri:String = s"${webServer.getUrl("").getProtocol}://localhost:${webServer.getPort}"

  abstract override def withFixture(test: NoArgTest) = {
    initWebServer()
    try     super.withFixture(test) // To be stackable, must call super.withFixture
    finally shutdownWebServer()
  }

  private def shutdownWebServer():Unit = {
    if (_webServer != null) {
      try     _webServer.shutdown()
      finally _webServer = null
    }
  }

  private def initWebServer():Unit = {
    _webServer = new MockWebServer
    _webServer.play(port)
  }

  def mockResponse(f:MockResponse => MockResponse):Unit = mockResponse(HttpURLConnection.HTTP_OK)(f)
  def mockResponse(responseCode:Int)(f:MockResponse => MockResponse) = webServer.enqueue(f(response(responseCode)))
  def takeRequest = webServer.takeRequest()

  private def response():MockResponse = response(HttpURLConnection.HTTP_OK)
  private def response(code:Int):MockResponse = new MockResponse()
                                                    .setHeader("Content-Type", WebServerMock.APPLICATION_JSON)
                                                    .setResponseCode(code)
}

object WebServerMock {
  val APPLICATION_JSON = "application/json"
  private[WebServerMock] val randomPort = 0
}
