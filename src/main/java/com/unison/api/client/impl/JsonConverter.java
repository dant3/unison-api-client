package com.unison.api.client.impl;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public abstract class JsonConverter<T> implements JsonSerializer<T>, JsonDeserializer<T>{
    public static <T> GsonBuilder install(GsonBuilder builder, Type type, JsonConverter<T> converter) {
        return builder.registerTypeAdapter(type, converter);
    }
}
