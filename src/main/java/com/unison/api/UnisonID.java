package com.unison.api;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor(suppressConstructorProperties = true, access = AccessLevel.PRIVATE)
public final class UnisonID {
    private final String value;


    public static UnisonID fromString(String value) {
        return new UnisonID(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
