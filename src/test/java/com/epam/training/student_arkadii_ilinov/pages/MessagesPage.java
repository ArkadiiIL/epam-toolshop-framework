package com.epam.training.student_arkadii_ilinov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MessagesPage extends BasePage {
    private static final String URL_PATH = "/account/messages";
    private static final By DETAILS_LINK_BY = By.linkText("Details");
    private static final By PARENT_ROW_BY = By.xpath("..");

    @FindBy(css = "table tbody td:first-child")
    private List<WebElement> subjectCells;

    public MessagesPage(WebDriver driver) {
        super(driver);
        waitForUrl(URL_PATH);
    }

    public List<String> getMessageSubjects() {
        return waitForTexts(subjectCells, "No rows in message table");
    }

    public MessageDetailsPage clickDetails(String subject) {
        WebElement subjectCell = findElementByTextInList(subjectCells, subject);
        WebElement row = subjectCell.findElement(PARENT_ROW_BY);
        row.findElement(DETAILS_LINK_BY).click();

        return new MessageDetailsPage(driver);
    }
}
