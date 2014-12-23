package com.unison.api;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class Room {
    @SerializedName("id") private UnisonID ID;
    @SerializedName("room_last_updated") private DateTime lastUpdated;

    private String title;
    private DateTime created;

}
