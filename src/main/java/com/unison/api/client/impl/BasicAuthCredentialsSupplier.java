package com.unison.api.client.impl;

import retrofit.RequestInterceptor;

import java.nio.charset.Charset;

public final class BasicAuthCredentialsSupplier implements RequestInterceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    private final String authHeader;

    private BasicAuthCredentialsSupplier(String login, String password) {
        this.authHeader = createAuthorizationHeader(login, password);
    }

    public static BasicAuthCredentialsSupplier create(String login, String password) {
        return new BasicAuthCredentialsSupplier(login, password);
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("authorization", authHeader);
    }

    private static String createAuthorizationHeader(String login, String password) {
        return "Basic " + new String(Base64Coder.encode(createAuthToken(login, password).getBytes(UTF8)));
    }

    private static String createAuthToken(String login, String password) {
        return login + ':' + password;
    }
}
