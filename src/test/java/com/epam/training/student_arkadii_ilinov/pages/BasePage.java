package com.epam.training.student_arkadii_ilinov.pages;

import com.epam.training.student_arkadii_ilinov.pages.component.Header;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
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

    protected String waitForText(WebElement element) {
        try {
            return wait.until(ignored -> {
                String text = element.getText().strip();
                return text.isEmpty() ? null : text;
            });
        } catch (TimeoutException e) {
            throw new NoSuchElementException("Text not found", e);
        }
    }

    protected List<String> waitForTexts(List<WebElement> elements, String errorMessage) {
        try {
            return wait.until(ignored -> {
                        List<String> list = elements.stream()
                                .map(WebElement::getText)
                                .map(String::strip)
                                .toList();
                        return list.isEmpty() ? null : list;
                    }
            );
        } catch (TimeoutException e) {
            throw new NoSuchElementException(errorMessage, e);
        }
    }

    protected WebElement findElementByTextInList(List<WebElement> list, String text) {
        try {
            return wait.until(ignored ->
                    list.stream()
                            .filter(element -> element.getText().strip().equals(text))
                            .findFirst()
                            .orElse(null));
        } catch (TimeoutException e) {
            throw new NoSuchElementException("Element with text '%s' not found!".formatted(text), e);
        }
    }

    protected void selectByValue(WebElement element, String value) {
        new Select(clickable(element)).selectByValue(value);
    }
}
