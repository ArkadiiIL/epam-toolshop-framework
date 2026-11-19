package com.epam.training.student_arkadii_ilinov.tests;

import com.epam.training.student_arkadii_ilinov.data.User;
import com.epam.training.student_arkadii_ilinov.data.UserFactory;
import com.epam.training.student_arkadii_ilinov.pages.HomePage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Test
    public void testRegistration() {
        User user = UserFactory.createNewUser();
        new HomePage(driver)
                .open()
                .header()
                .clickSignIn()
                .clickRegisterLink()
                .fillRegisterForm(user)
                .clickRegisterButton();
    }
}
