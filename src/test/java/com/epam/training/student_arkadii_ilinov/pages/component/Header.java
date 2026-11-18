package com.epam.training.student_arkadii_ilinov.pages.component;

import com.epam.training.student_arkadii_ilinov.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Header extends BasePage {
    @FindBy(css = "a[data-test='nav-cart']")
    private List<WebElement> cartIcon;

    public Header(WebDriver driver) {
        super(driver);
    }

    public boolean isCartIconPresent() {
        return !cartIcon.isEmpty();
    }
}
