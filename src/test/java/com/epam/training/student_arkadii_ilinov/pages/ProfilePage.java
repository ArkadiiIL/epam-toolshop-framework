package com.epam.training.student_arkadii_ilinov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    private static final String URL_PATH = "/account/profile";

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    public ProfilePage(WebDriver driver) {
        super(driver);
        waitForUrl(URL_PATH);
        waitUntilHasValue(firstNameField);
    }

    public String getFirstName() {
        return getFieldValue(firstNameField);
    }

    public String getLastName() {
        return getFieldValue(lastNameField);
    }

    public String getEmail() {
        return getFieldValue(emailField);
    }

    public String getPhone() {
        return getFieldValue(phoneField);
    }
}
