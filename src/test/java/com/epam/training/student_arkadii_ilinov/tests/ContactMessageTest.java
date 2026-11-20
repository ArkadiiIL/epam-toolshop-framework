package com.epam.training.student_arkadii_ilinov.tests;

import com.epam.training.student_arkadii_ilinov.data.User;
import com.epam.training.student_arkadii_ilinov.data.UserFactory;
import com.epam.training.student_arkadii_ilinov.pages.*;
import com.epam.training.student_arkadii_ilinov.steps.UserSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactMessageTest extends BaseTest {
    private static final String PAYMENTS_SUBJECT_VALUE = "payments";
    private static final String EXPECTED_SUCCESS_TEXT = "Thanks for your message! We will contact you shortly.";
    private static final String USER_MESSAGE =
            "I have a question about my last payment. Can you check it, please?";
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
        ContactPage contactPage = accountPage.header().clickContact();
        String actualSuccessText =
                contactPage.selectSubject(PAYMENTS_SUBJECT_VALUE)
                        .enterMessage(USER_MESSAGE)
                        .clickSend()
                        .getSuccessMessageText();

        assertEquals(actualSuccessText, EXPECTED_SUCCESS_TEXT);

        MessagesPage messagesPage = contactPage.header().clickUserMenu().clickMyMessages();
        List<String> messageSubjects = messagesPage.getMessageSubjects();

        assertTrue(
                messageSubjects.contains(PAYMENTS_SUBJECT_VALUE),
                "%s is not in the message subjects list: %s".formatted(PAYMENTS_SUBJECT_VALUE, messageSubjects)
        );

        String actualUserMessage = messagesPage.clickDetails(PAYMENTS_SUBJECT_VALUE).getMessageText();

        assertEquals(actualUserMessage, USER_MESSAGE);
    }
}
