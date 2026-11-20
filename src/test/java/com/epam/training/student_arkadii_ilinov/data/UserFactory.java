package com.epam.training.student_arkadii_ilinov.data;

import com.epam.training.student_arkadii_ilinov.util.RandomGeneratorUtil;

import java.time.LocalDate;

public final class UserFactory {

    private UserFactory() {
    }

    public static User createNewUser() {
        return new User(
                "TestName",
                "TestLastName",
                LocalDate.of(1990, 5, 10),
                "PL",
                "31-432",
                "1",
                "512849301",
                RandomGeneratorUtil.generateEmail(),
                RandomGeneratorUtil.generatePassword()
        );
    }
}
