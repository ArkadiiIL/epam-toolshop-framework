package com.epam.training.student_arkadii_ilinov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {
    private static final String URL_PATH = "/contact";

    @FindBy(id = "subject")
    private WebElement subjectDropdown;

    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(css = "input[data-test='contact-submit']")
    private WebElement sendButton;

    @FindBy(css = "div[role='alert'].alert-success")
    private WebElement successMessage;

    public ContactPage(WebDriver driver) {
        super(driver);
        waitForUrl(URL_PATH);
    }

    public ContactPage selectSubject(String subject) {
        selectByValue(subjectDropdown, subject);
        return this;
    }

    public ContactPage enterMessage(String message) {
        type(messageField, message);
        return this;
    }

    public ContactPage clickSend() {
        clickable(sendButton).click();
        return this;
    }

    public String getSuccessMessageText() {
        return visible(successMessage).getText().strip();
    }
}
