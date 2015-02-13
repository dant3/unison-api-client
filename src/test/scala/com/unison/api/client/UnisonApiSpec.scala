package com.unison.api.client

import org.scalatest.{Matchers, WordSpec}

class UnisonApiSpec extends WordSpec with Matchers with WebServerMock with Fixtures {
  "Unison Api" should {
    "be able to query who is user with basic auth" in {
      mockResponse(_.setBody(whoAmIResponse))

      val currentUser = testClient.whoAmI()
      currentUser should === (whoAmI)

      val authHeader = takeRequest.getHeader("authorization")
      authHeader should === (authHeaderSample)
    }

    "be able to get list of rooms" in {
      mockResponse(_.setBody(roomsResponse))

      testClient.getRooms should === (testRooms)
    }
  }

  def testClient = UnisonApiClient.create(login, passwd, webServerUri)
}
