package com.avishek.config;

public enum Environment {
    DEV,
    QA,
    STAGING,
    PROD;

    public static Environment from (String environment) {

        return Environment.valueOf(environment.trim().toUpperCase());
    }
}
