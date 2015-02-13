package com.unison.api.client;

import com.google.gson.GsonBuilder;
import com.unison.api.UnisonApi;
import com.unison.api.client.impl.*;
import retrofit.RestAdapter;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

public final class UnisonApiClient {
    private static final String UNISON_API_URI = "https://unison.com/api/v1";

    private UnisonApiClient() {
        /* no-op */
    }

    /*package*/ static UnisonApi create(String login, String password, String apiUri) {
        final RestAdapter restAdapter = createRestAdapter(login, password, apiUri);
        return restAdapter.create(UnisonApi.class);
    }


    public static UnisonApi create(String login, String password) {
        return create(login, password, UNISON_API_URI);
    }

    private static RestAdapter createRestAdapter(String login, String password, String apiUri) {
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(createConverter())
                .setEndpoint(apiUri)
                .setLog(Slf4JLog.create())
                .setRequestInterceptor(BasicAuthCredentialsSupplier.create(login, password))
                .build();
    }

    private static Converter createConverter() {
        final GsonBuilder builder = new GsonBuilder();
        JsonConverter.install(builder, DateTimeConverter.TYPE, DateTimeConverter.getInstance());
        JsonConverter.install(builder, UserIDConverter.TYPE, UserIDConverter.getInstance());
        JsonConverter.install(builder, UnisonIDConverter.TYPE, UnisonIDConverter.getInstance());
        return new GsonConverter(builder.create());
    }
}
