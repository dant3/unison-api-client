package com.unison.api.client.impl;

import com.google.gson.*;
import com.unison.api.UnisonID;

import java.lang.reflect.Type;

public final class UnisonIDConverter extends JsonConverter<UnisonID> {
    private static final UnisonIDConverter instance = new UnisonIDConverter();

    private UnisonIDConverter() { super(); }

    public static UnisonIDConverter getInstance() {
        return instance;
    }

    @Override
    public UnisonID deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return UnisonID.fromString(json.getAsString());
    }

    @Override
    public JsonElement serialize(UnisonID src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}
