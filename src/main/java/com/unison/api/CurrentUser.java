package com.unison.api;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class CurrentUser {
    @SerializedName("id") private UserID ID;

    private String name;
    private String email;
    private DateTime created;
}
