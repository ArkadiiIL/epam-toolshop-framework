package com.epam.training.student_arkadii_ilinov.pages.component;

import com.epam.training.student_arkadii_ilinov.pages.BasePage;
import com.epam.training.student_arkadii_ilinov.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Header extends BasePage {
    @FindBy(css = "a[data-test='nav-cart']")
    private List<WebElement> cartNav;

    @FindBy(css = "a[data-test='nav-sign-in']")
    private WebElement signInNav;

    @FindBy(id = "menu")
    private WebElement userMenu;

    public Header(WebDriver driver) {
        super(driver);
    }

    public boolean isCartNavPresent() {
        return !cartNav.isEmpty();
    }

    public LoginPage clickSignIn() {
        clickable(signInNav).click();
        return new LoginPage(driver);
    }

    public String getUserName() {
        return visible(userMenu).getText().strip();
    }
}
