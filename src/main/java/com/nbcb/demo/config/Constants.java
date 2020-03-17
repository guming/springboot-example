package com.nbcb.demo.config;


/**
 * Application constants.
 */
public final class Constants {

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";

    public static final String REQUEST_ID_FIELD_NAME = "X-Trace-ID";

    public static final String REST_BASE_URL_PATTERN = "/api";

    public static final String APPLICATION_JSON_API_VALUE = "application/vnd.api+json";


    // Date Formatting
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static final String DEFAULT_TIMEZONE = "GMT+08:00";
    private Constants() {
    }
}
