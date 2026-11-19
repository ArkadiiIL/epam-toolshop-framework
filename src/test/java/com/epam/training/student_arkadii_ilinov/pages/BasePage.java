package com.epam.training.student_arkadii_ilinov.pages;

import com.epam.training.student_arkadii_ilinov.pages.component.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    protected WebElement clickable(WebElement element) {
        return wait.until(elementToBeClickable(element));
    }

    protected WebElement visible(WebElement element) {
        return wait.until(visibilityOf(element));
    }

    protected void type(WebElement element, String text) {
        clickable(element).sendKeys(text);
    }
}
