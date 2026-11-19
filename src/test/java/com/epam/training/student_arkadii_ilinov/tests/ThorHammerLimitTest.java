package com.epam.training.student_arkadii_ilinov.tests;

import com.epam.training.student_arkadii_ilinov.pages.HomePage;
import com.epam.training.student_arkadii_ilinov.pages.ProductPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ThorHammerLimitTest extends BaseTest {
    private static final String NAME_DESC_OPTION = "name,desc";
    private static final String HAMMER_CATEGORY_NAME = "Hammer";
    private static final String THOR_HAMMER_NAME = "Thor Hammer";
    private static final String TOAST_LIMIT_MESSAGE = "You can only have one Thor Hammer in the cart.";
    private static final int MAX_PRICE = 13;
    private static final int ITEM_QUANTITY = 2;

    @Test
    public void testThorHammerLimit() {
        HomePage homePage = new HomePage(driver);
        List<String> filteredItemList = homePage
                .open()
                .sortBy(NAME_DESC_OPTION)
                .setMaxPrice(MAX_PRICE)
                .setCategorySelected(HAMMER_CATEGORY_NAME, true)
                .filteredProductNames();

        assertTrue(
                filteredItemList.contains(THOR_HAMMER_NAME),
                "%s is not in the filtered list: %s".formatted(THOR_HAMMER_NAME, filteredItemList)
        );

        ProductPage productPage = homePage.openProduct(THOR_HAMMER_NAME);

        String toastMessage = productPage
                .setQuantity(ITEM_QUANTITY)
                .addToCart()
                .getToastMessage();


        assertEquals(toastMessage, TOAST_LIMIT_MESSAGE);

        boolean isCartIconPresent = productPage.header().isCartIconPresent();

        assertFalse(isCartIconPresent, "Cart icon is shown, but Thor Hammer should not be added");
    }
}
