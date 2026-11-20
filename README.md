# WebDriverToolShopTest

Study WebDriver test framework for https://practicesoftwaretesting.com/ site.
EPAM Automated Testing in Java course task.

## Run

You need Java 21.

mvn test

## Scenarios

1. Thor Hammer limit - filter products, open Thor Hammer and check that you can't add 2 of them to the cart.
2. Registration - register a new user, log in and check the data in the profile.
3. Contact message - send a message from the Contact page and check it in My messages.

## Notes

It is a public demo site for studying test automation. Other users can add products to the store, so data on the site can change and tests can fail because of it.