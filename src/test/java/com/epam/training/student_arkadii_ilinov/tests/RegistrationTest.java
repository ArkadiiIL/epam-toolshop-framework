package com.epam.training.student_arkadii_ilinov.tests;

import com.epam.training.student_arkadii_ilinov.data.User;
import com.epam.training.student_arkadii_ilinov.data.UserFactory;
import com.epam.training.student_arkadii_ilinov.pages.AccountPage;
import com.epam.training.student_arkadii_ilinov.pages.HomePage;
import com.epam.training.student_arkadii_ilinov.pages.ProfilePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class RegistrationTest extends BaseTest {
    @Test
    public void testRegistration() {
        User user = UserFactory.createNewUser();
        String expectedUsername = "%s %s".formatted(user.firstName(), user.lastName());
        AccountPage accountPage = new HomePage(driver)
                .open()
                .header()
                .clickSignIn()
                .clickRegisterLink()
                .fillRegisterForm(user)
                .clickRegisterButton()
                .fillLoginForm(user.email(), user.password())
                .clickLoginButton();
        String actualUsername = accountPage.header().getUserName();

        assertEquals(actualUsername, expectedUsername);

        ProfilePage profilePage = accountPage.clickProfile();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(profilePage.getFirstName(), user.firstName(), "First name in profile");
        softAssert.assertEquals(profilePage.getLastName(), user.lastName(), "Last name in profile");
        softAssert.assertEquals(profilePage.getPhone(), user.phone(), "Phone in profile");
        softAssert.assertEquals(profilePage.getEmail(), user.email(), "Email in profile");
        softAssert.assertAll();
    }
}
