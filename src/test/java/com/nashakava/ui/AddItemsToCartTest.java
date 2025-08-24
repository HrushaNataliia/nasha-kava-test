package com.nashakava.ui;

import com.nashakava.ui.component.HeaderComponent;
import com.nashakava.ui.page.MainPage;
import com.nashakava.ui.testrunners.BaseTestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddItemsToCartTest extends BaseTestRunner {

    @Test
    @Description("Verify adding multiple items updates cart counter in header.")
    @Feature("Cart Counter Update")
    @Owner("Hrusha Nataliia")
    public void verifyAddingMultipleItemsUpdatesCartCounterInHeader() {
        SoftAssert softAssert = new SoftAssert();

        MainPage menuPage = new MainPage(driver);
        HeaderComponent header = menuPage.getHeader();

        int initialCount = header.getTotalNumberFromHeaderCartCounter();
        System.out.println(initialCount);
        softAssert.assertEquals(initialCount, 0, "Initial counter should be 0");

    }
}
