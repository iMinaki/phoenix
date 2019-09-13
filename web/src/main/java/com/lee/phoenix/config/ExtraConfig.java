package com.lee.phoenix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExtraConfig {
    private static boolean isDev;

    @Autowired
    public ExtraConfig(@Value("${isDev}") boolean isDev) {
        ExtraConfig.isDev = isDev;
    }

    public static boolean isDev() {
        return ExtraConfig.isDev;
    }
}
