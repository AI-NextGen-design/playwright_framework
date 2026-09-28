package com.avishek.config;

import Constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private ConfigManager() {
    }

    private static void loadProperties() {

        String environment = System.getProperty(
                "env",
                FrameworkConstants.DEFAULT_ENVIRONMENT
        );

        Environment currentEnvironment =
                Environment.from(environment);

        String filePath =
                FrameworkConstants.CONFIG_DIRECTORY
                        + "/"
                        + currentEnvironment.name().toLowerCase()
                        + ".properties";

        try (InputStream inputStream =
                     new FileInputStream(filePath)) {

            properties.load(inputStream);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load configuration file: " + filePath,
                    e
            );
        }
    }

    public static String get(String key) {

        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                    "Configuration property not found: " + key
            );
        }

        return value.trim();
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public static int getTimeout() {
        return Integer.parseInt(get("timeout"));
    }

    public static int getNavigationTimeout() {
        return Integer.parseInt(
                get("navigation.timeout")
        );
    }

    public static String getUsername() {
        return get("username");
    }

    public static String getPassword() {
        return get("password");
    }
}
