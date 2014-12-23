package com.unison.api.client.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.RestAdapter;


public final class Slf4JLog implements RestAdapter.Log {
    private static final String LOGGER_NAME = "Unison";

    private final Logger logger;

    private Slf4JLog(String loggerName) {
        this.logger = LoggerFactory.getLogger(loggerName);
    }

    public static Slf4JLog create() {
        return new Slf4JLog(LOGGER_NAME);
    }

    @Override
    public void log(String message) {
        logger.debug(message);
    }
}
