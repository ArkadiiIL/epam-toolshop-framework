package com.epam.training.student_arkadii_ilinov.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_URL = "https://practicesoftwaretesting.com/";
    private static final String ARIA_VALUE_NOW = "aria-valuenow";
    private static final By CHECKBOX_INPUT_BY = By.tagName("input");

    @FindBy(css = "select[data-test='sort']")
    private WebElement sortDropdown;

    @FindBy(css = ".ngx-slider-pointer-max")
    private WebElement maxSliderPoint;

    @FindBy(xpath = "//fieldset[legend='Categories']//div[contains(@class, 'checkbox')]")
    private List<WebElement> categoryCheckBoxList;

    @FindBy(css = "[data-test='filter_completed'] a[data-test^='product-'] h5")
    private List<WebElement> filteredProductItemList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.navigate().to(HOME_PAGE_URL);
        return this;
    }

    public HomePage sortBy(String sortOption) {
        new Select(clickable(sortDropdown)).selectByValue(sortOption);
        return this;
    }

    public HomePage setMaxPrice(int maxPrice) {
        WebElement clickablePoint = clickable(maxSliderPoint);
        int valueMin = getIntDomAttribute(clickablePoint, "aria-valuemin");
        int valueMax = getIntDomAttribute(clickablePoint, "aria-valuemax");
        if (maxPrice < valueMin || maxPrice > valueMax) {
            throw new IllegalArgumentException(
                    "Max price %d is out of range %d - %d".formatted(maxPrice, valueMin, valueMax));
        }
        int valueNow = getIntDomAttribute(clickablePoint, ARIA_VALUE_NOW);
        Keys stepDirection = valueNow < maxPrice ? Keys.ARROW_RIGHT : Keys.ARROW_LEFT;
        clickablePoint.click();

        while (valueNow != maxPrice) {
            clickablePoint.sendKeys(stepDirection);
            int previousValueNow = valueNow;
            valueNow = getIntDomAttribute(clickablePoint, ARIA_VALUE_NOW);
            if (valueNow == previousValueNow) {
                throw new IllegalStateException(
                        "Slider stopped at %d, expected %d".formatted(valueNow, maxPrice)
                );
            }
        }
        return this;
    }

    public HomePage setCategorySelected(String name, boolean selected) {
        WebElement checkBoxInput =
                findElementByTextInList(categoryCheckBoxList, name).findElement(CHECKBOX_INPUT_BY);
        if (checkBoxInput.isSelected() != selected) {
            checkBoxInput.click();
        }
        return this;
    }

    public ProductPage clickProduct(String productName) {
        findElementByTextInList(filteredProductItemList, productName).click();
        return new ProductPage(driver);
    }

    public List<String> filteredProductNames() {
        try {
            return wait.until(ignored -> {
                        List<String> list = filteredProductItemList.stream()
                                .map(WebElement::getText)
                                .toList();
                        return list.isEmpty() ? null : list;
                    }
            );
        } catch (TimeoutException e) {
            throw new NoSuchElementException("No products found after filtering", e);
        }
    }

    private int getIntDomAttribute(WebElement element, String name) {
        return Integer.parseInt(getDomAttributeValue(element, name));
    }

    private WebElement findElementByTextInList(List<WebElement> list, String text) {
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
}
