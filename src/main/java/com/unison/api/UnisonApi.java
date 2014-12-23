package com.unison.api;


import lombok.Value;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import java.util.List;

@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public interface UnisonApi {
    static final String ROOM_ID = "room_id";
    static final String TOPIC_ID = "topic_id";
    static final String COMMENT_ID = "topic_id";

    @GET("/whoami")
    CurrentUser whoAmI();

    @GET("/rooms")
    List<Room> getRooms();

    @GET("/rooms/{" + ROOM_ID + "}")
    Room getRoom(@Path(ROOM_ID) UnisonID roomID);

    @POST("/rooms")
    Room createRoom(@Body NewRoomData newRoomData);

    @GET("/rooms/{" + ROOM_ID + "}/topics")
    List<Topic> getTopics(@Path(ROOM_ID) UnisonID roomID);

    @GET("/rooms/{" + ROOM_ID + "}/topics/{" + TOPIC_ID + "}")
    Topic getTopic(@Path(ROOM_ID) UnisonID roomID, @Path(TOPIC_ID) UnisonID topicID);

    @POST("/rooms/{" + ROOM_ID + "}/topics")
    Topic createTopic(@Path(ROOM_ID) UnisonID roomID, @Body NewTopicData newTopicData);

    @GET("/rooms/{" + ROOM_ID + "}/topics/{" + TOPIC_ID + "}/comments")
    List<Comment> getComments(@Path(ROOM_ID) UnisonID roomID, @Path(TOPIC_ID) UnisonID topicID);

    @GET("/rooms/{" + ROOM_ID + "}/topics/{" + TOPIC_ID + "}/comments/{" + COMMENT_ID + "}")
    Comment getComment(@Path(ROOM_ID) UnisonID roomID,
                       @Path(TOPIC_ID) UnisonID topicID,
                       @Path(COMMENT_ID) UnisonID commentID);


    @POST("/rooms/{" + ROOM_ID + "}/topics/{" + TOPIC_ID + "}/comments")
    Comment createComment(@Path(ROOM_ID) UnisonID roomID, @Path(TOPIC_ID) UnisonID topicID, @Body NewCommentData comment);



    @Value(staticConstructor = "create")
    static class NewRoomData {
        private final String title;
    }

    @Value(staticConstructor = "create")
    static class NewTopicData {
        private final String text;
    }

    @Value(staticConstructor = "create")
    static class NewCommentData {
        private final String text;
    }
}
