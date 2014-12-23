package com.unison.api.client.impl;

import com.google.gson.*;
import com.unison.api.UserID;

import java.lang.reflect.Type;

public final class UserIDConverter extends JsonConverter<UserID> {
    private static final UserIDConverter instance = new UserIDConverter();

    private UserIDConverter() { super(); }

    public static UserIDConverter getInstance() {
        return instance;
    }


    @Override
    public UserID deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return UserID.fromLong(json.getAsLong());
    }

    @Override
    public JsonElement serialize(UserID src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toLong());
    }
}
