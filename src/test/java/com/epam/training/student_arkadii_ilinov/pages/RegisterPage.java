package com.epam.training.student_arkadii_ilinov.pages;

import com.epam.training.student_arkadii_ilinov.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {
    private static final String URL_PATH = "auth/register";

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "dob")
    private WebElement dateOfBirthField;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "postal_code")
    private WebElement postalCodeField;

    @FindBy(id = "house_number")
    private WebElement houseNumberField;

    @FindBy(id = "street")
    private WebElement streetField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[data-test='register-submit']")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        waitForUrl(URL_PATH);
    }

    public RegisterPage fillRegisterForm(User user) {
        type(firstNameField, user.firstName());
        type(lastNameField, user.lastName());
        type(dateOfBirthField, user.dateOfBirth().toString());
        selectCountryByValue(user.country());
        type(postalCodeField, user.postalCode());
        type(houseNumberField, user.houseNumber());
        type(phoneField, user.phone());
        type(emailField, user.email());
        type(passwordField, user.password());
        waitUntilHasValue(streetField);
        return this;
    }

    public LoginPage clickRegisterButton() {
        clickable(registerButton).click();
        return new LoginPage(driver);
    }

    private void selectCountryByValue(String country) {
        new Select(clickable(countryDropdown)).selectByValue(country);
    }
}
