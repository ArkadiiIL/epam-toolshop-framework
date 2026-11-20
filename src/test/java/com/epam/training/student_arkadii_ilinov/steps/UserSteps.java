package com.epam.training.student_arkadii_ilinov.steps;

import com.epam.training.student_arkadii_ilinov.data.User;
import com.epam.training.student_arkadii_ilinov.pages.AccountPage;
import com.epam.training.student_arkadii_ilinov.pages.LoginPage;

public final class UserSteps {
    private UserSteps() {
    }

    public static LoginPage register(LoginPage loginPage, User user) {
        return loginPage
                .clickRegisterLink()
                .fillRegisterForm(user)
                .clickRegisterButton();
    }

    public static AccountPage login(LoginPage loginPage, User user) {
        return loginPage
                .fillLoginForm(user.email(), user.password())
                .clickLoginButton();
    }
}
