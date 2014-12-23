package com.unison.api;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class Topic {
    @SerializedName("id") private String ID;
    @SerializedName("room_id") private String roomID;
    @SerializedName("last_commented") private DateTime lastCommented;

    private String subject;
    private User author;
    private DateTime created;

}
