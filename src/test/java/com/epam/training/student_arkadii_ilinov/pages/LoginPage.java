package com.epam.training.student_arkadii_ilinov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(css = "input[data-test='login-submit']")
    private WebElement loginButton;

    @FindBy(css = "a[data-test='register-link']")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage clickRegisterLink() {
        clickable(registerLink).click();
        return new RegisterPage(driver);
    }
}
