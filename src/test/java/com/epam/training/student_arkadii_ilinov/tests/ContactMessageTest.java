package com.epam.training.student_arkadii_ilinov.tests;

import com.epam.training.student_arkadii_ilinov.data.User;
import com.epam.training.student_arkadii_ilinov.data.UserFactory;
import com.epam.training.student_arkadii_ilinov.pages.AccountPage;
import com.epam.training.student_arkadii_ilinov.pages.HomePage;
import com.epam.training.student_arkadii_ilinov.pages.LoginPage;
import com.epam.training.student_arkadii_ilinov.steps.UserSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactMessageTest extends BaseTest {
    private AccountPage accountPage;

    @BeforeMethod
    public void logInAsNewUser() {
        User user = UserFactory.createNewUser();
        LoginPage loginPage = new HomePage(driver).open().header().clickSignIn();
        loginPage = UserSteps.register(loginPage, user);
        accountPage = UserSteps.login(loginPage, user);
    }

    @Test
    public void testContactMessage() {

    }
}
