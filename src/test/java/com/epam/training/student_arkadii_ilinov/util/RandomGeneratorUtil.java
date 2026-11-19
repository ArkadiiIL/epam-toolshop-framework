package com.epam.training.student_arkadii_ilinov.util;

import java.util.UUID;

public final class RandomGeneratorUtil {
    private static final String EMAIL_DOMAIN = "@example.com";
    private static final String PASSWORD_PREFIX = "Aa1@";

    private RandomGeneratorUtil() {
    }

    public static String generatePassword() {
        return PASSWORD_PREFIX + randomPart();
    }

    public static String generateEmail() {
        return "user_" + randomPart() + EMAIL_DOMAIN;
    }

    private static String randomPart() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
