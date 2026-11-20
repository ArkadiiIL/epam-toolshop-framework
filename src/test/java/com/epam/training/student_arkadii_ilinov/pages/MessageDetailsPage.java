package com.epam.training.student_arkadii_ilinov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessageDetailsPage extends BasePage {
    private static final String URL_PATH = "/account/messages/";

    @FindBy(css = ".card:first-child .card-text")
    private WebElement messageText;

    public MessageDetailsPage(WebDriver driver) {
        super(driver);
        waitForUrl(URL_PATH);
    }

    public String getMessageText() {
        return waitForText(messageText);
    }
}
