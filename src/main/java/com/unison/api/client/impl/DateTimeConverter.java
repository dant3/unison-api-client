package com.unison.api.client.impl;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.ISODateTimeFormat;

import java.lang.reflect.Type;

public class DateTimeConverter extends JsonConverter<DateTime> {
    private static final DateTimeConverter instance = new DateTimeConverter();
    public static final Type TYPE = new TypeToken<DateTime>(){}.getType();

    public static DateTimeConverter getInstance() {
        return instance;
    }

    private final DateTimeFormatter fmt = new DateTimeFormatterBuilder()
            .append(ISODateTimeFormat.date())
            .appendLiteral(' ')
            .append(ISODateTimeFormat.hourMinuteSecond())
            .toFormatter();

    private DateTimeConverter() {
        super();
    }

    @Override
    public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return fmt.parseDateTime(json.getAsString());
    }

    @Override
    public JsonElement serialize(DateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(fmt.print(src));
    }
}
