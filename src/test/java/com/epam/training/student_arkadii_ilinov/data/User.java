package com.epam.training.student_arkadii_ilinov.data;

import java.time.LocalDate;

public record User(
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String country,
        String postalCode,
        String houseNumber,
        String phone,
        String email,
        String password
) {
}
