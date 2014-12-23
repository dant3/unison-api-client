package com.unison.api;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class Comment {
    @SerializedName("id") private String ID;
    @SerializedName("topic_id") private String topicID;
    @SerializedName("room_id") private String roomID;

    private String text;
    private User author;
    private DateTime created;

}
