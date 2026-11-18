package com.epam.training.student_arkadii_ilinov.tests;

import com.epam.training.student_arkadii_ilinov.pages.HomePage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ThorHammerLimitTest extends BaseTest {
    private static final String NAME_DESC_OPTION = "name,desc";
    private static final String HAMMER_CATEGORY_NAME = "Hammer";
    private static final List<String> EXPECTED_HAMMERS = List.of("Thor Hammer", "Hammer", "Claw Hammer");
    private static final int MAX_PRICE = 13;

    @Test
    public void testThorHammerLimit() {
        HomePage homePage = new HomePage(driver);
        List<String> filteredItemList = homePage
                .open()
                .sortBy(NAME_DESC_OPTION)
                .setMaxPrice(MAX_PRICE)
                .setCategorySelected(HAMMER_CATEGORY_NAME, true)
                .filteredProductNames();

        List<String> knownProducts = filteredItemList.stream()
                .filter(EXPECTED_HAMMERS::contains)
                .toList();

        assertEquals(knownProducts, EXPECTED_HAMMERS);
    }
}
