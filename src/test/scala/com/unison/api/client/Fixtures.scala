package com.unison.api.client

import com.unison.api.{UnisonID, UserID, CurrentUser, Room}
import org.apache.commons.codec.binary.Base64
import org.joda.time.DateTime

trait Fixtures {
  val login = "test"
  val passwd = "123456"

  val authHeaderSample = s"Basic ${Base64.encodeBase64String(s"$login:$passwd".getBytes)}"

  val whoAmIResponse = """{"id":12345,"email":"useremail","name":"Test User","created":"2014-01-28 13:12:01"}"""
  val whoAmI = new CurrentUser(UserID.fromLong(12345), "useremail", "Test User", DateTime.parse("2014-01-28 13:12:01"))

  val testRoom1 = new Room(UnisonID.fromString("1hHNOu7VyGt"), DateTime.parse("2014-02-12 07:00:19"),
                           "test room number 1", DateTime.parse("2014-02-07 15:03:50"))
  val testRoom2 = new Room(UnisonID.fromString("1hGv6MDeAOt"), DateTime.parse("2014-02-14 14:31:08"),
                           "The test number 2", DateTime.parse("2014-02-06 12:01:47"))
  val testRooms = List(testRoom1, testRoom2)


  val roomsResponse = """[{"id":"1hHNOu7VyGt",
                        |  "title":"test room number 1",
                        |  "created":"2014-02-07 15:03:50",
                        |  "room_last_updated":"2014-02-12 07:00:19"},
                        |{ "id":"1hGv6MDeAOt",
                        |  "title":"The test number 2",
                        |  "created":"2014-02-06 12:01:47",
                        |  "room_last_updated":"2014-02-14 14:31:08"}]""".stripMargin
}
