package com.epam.training.student_arkadii_ilinov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    private static final String URL_PATH = "/account";

    @FindBy(css = "a[data-test='nav-profile']")
    private WebElement profileNav;

    public AccountPage(WebDriver driver) {
        super(driver);
        waitForUrl(URL_PATH);
    }

    public ProfilePage clickProfile() {
        clickable(profileNav).click();
        return new ProfilePage(driver);
    }


}
