package com.unison.api;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor(suppressConstructorProperties = true, access = AccessLevel.PRIVATE)
public final class UserID {
    private final long value;

    public static UserID fromLong(long value) {
        return new UserID(value);
    }

    public long toLong() {
        return value;
    }

    @Override
    public String toString() {
        return "UserID(" + value + ')';
    }
}
