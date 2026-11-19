package com.epam.training.student_arkadii_ilinov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private static final String URL_PATH = "auth/login";

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
        waitForUrl(URL_PATH);
    }

    public LoginPage fillLoginForm(String email, String password) {
        type(emailInputField, email);
        type(passwordInputField, password);
        return this;
    }

    public RegisterPage clickRegisterLink() {
        clickable(registerLink).click();
        return new RegisterPage(driver);
    }

    public AccountPage clickLoginButton() {
        clickable(loginButton).click();
        return new AccountPage(driver);
    }
}
