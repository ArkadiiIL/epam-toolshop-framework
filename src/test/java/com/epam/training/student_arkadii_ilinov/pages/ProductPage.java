package com.epam.training.student_arkadii_ilinov.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(css = "input[data-test='quantity']")
    private WebElement quantityField;
    @FindBy(css = "button[data-test='add-to-cart']")
    private WebElement addToCartButton;
    @FindBy(css = "div[role='alert'].toast-message")
    private WebElement toastWindow;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage setQuantity(int quantity) {
        Keys platformKey = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
        String selectAll = Keys.chord(platformKey, "a");
        clickable(quantityField).sendKeys(selectAll, Integer.toString(quantity));
        return this;
    }

    public ProductPage addToCart() {
        clickable(addToCartButton).click();
        return this;
    }

    public String getToastMessage() {
       return visible(toastWindow).getText().strip();
    }
}
