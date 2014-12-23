package com.unison.api.client.impl;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.Validate;

import java.lang.reflect.Type;

public abstract class JsonConverter<T> implements JsonSerializer<T>, JsonDeserializer<T>{
    public final Type TYPE = new TypeToken<T>(){}.getType();

    public static <T> GsonBuilder install(GsonBuilder builder, JsonConverter<T> converter) {
        return Validate.notNull(builder).registerTypeAdapter(converter.TYPE, converter);
    }
}
