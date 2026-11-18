package com.epam.training.student_arkadii_ilinov.tests;

import com.epam.training.student_arkadii_ilinov.pages.HomePage;
import org.testng.annotations.Test;

public class ThorHammerLimitTest extends BaseTest {
    private static final String NAME_DESC_OPTION = "name,desc";
    private static final String HAMMER_CATEGORY_NAME = "Hammer";

    @Test
    public void testThorHammerLimit() {
        new HomePage(driver)
                .open()
                .sortBy(NAME_DESC_OPTION)
                .setMaxPrice(13)
                .setCategorySelected(HAMMER_CATEGORY_NAME, true);
    }
}
