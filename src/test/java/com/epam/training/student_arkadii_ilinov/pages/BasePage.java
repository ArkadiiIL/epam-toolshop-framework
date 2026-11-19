package com.epam.training.student_arkadii_ilinov.pages;

import com.epam.training.student_arkadii_ilinov.pages.component.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    public Header header() {
        return new Header(driver);
    }

    protected void waitForUrl(String urlPart) {
        wait.until(urlContains(urlPart));
    }

    protected WebElement clickable(WebElement element) {
        return wait.until(elementToBeClickable(element));
    }

    protected WebElement visible(WebElement element) {
        return wait.until(visibilityOf(element));
    }

    protected void type(WebElement element, String text) {
        clickable(element).sendKeys(text);
    }

    protected String getDomAttributeValue(WebElement element, String attributeName) {
        return Objects.requireNonNull(
                element.getDomAttribute(attributeName),
                "Attribute '%s' not found".formatted(attributeName));
    }

    protected String getFieldValue(WebElement element) {
        return element.getDomProperty("value");
    }

    protected void waitUntilHasValue(WebElement element) {
        wait.until(attributeToBeNotEmpty(element, "value"));
    }
}
