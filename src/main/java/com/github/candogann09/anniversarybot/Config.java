package com.github.candogann09.anniversarybot;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Locale;

public class Config {

    private static final Dotenv dotEnv = Dotenv.load();

    public static String get(String key) {
        return dotEnv.get(key.toUpperCase(Locale.ROOT));
    }
}
