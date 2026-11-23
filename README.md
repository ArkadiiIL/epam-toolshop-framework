# WebDriverToolShopTest

Study WebDriver test framework for https://practicesoftwaretesting.com/ site.
EPAM Automated Testing in Java course task.

## Run

You need Java 21.

mvn test

## Scenarios

### 1. Thor Hammer limit
Test data: price 1–13, category Hammer, Thor Hammer, quantity 2
1. Open https://practicesoftwaretesting.com/
2. Set sort by name (Z - A)
3. Set price range from 1 to 13
4. Set filter by Hammer
5. Verify that Thor Hammer is in the list
6. Open Thor Hammer
7. Change quantity to 2
8. Click Add to cart
9. Verify the error message "You can only have one Thor Hammer in the cart."
10. Check that the cart icon is not shown in the header

### 2. Registration
1. Open https://practicesoftwaretesting.com/
2. Click Sign in
3. Click on "Register your account"
4. Fill in the registration form (with a random email)
5. Click Register
6. Check that the login page is opened
7. Log in with the new email and password
8. Verify that the My account page is opened and the user name is in the header
9. Click Profile
10. Check that first name, last name, email and phone are the same as in registration

### 3. Contact message
Precondition: a new user is registered and logged in (like in Scenario 2)
1. Click Contact in the header
2. Choose Payments subject
3. Enter a message (min 50 characters)
4. Click Send
5. Verify the text "Thanks for your message! We will contact you shortly."
6. Click on the user name in the header
7. Choose My messages
8. Check that the list has a message with subject "payments"
9. Open Details and verify that the message text is the same

## Notes

It is a public demo site for studying test automation. Other users can add products to the store, so data on the site can change and tests can fail because of it.