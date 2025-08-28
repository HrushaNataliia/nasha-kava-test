package com.nashakava.ui;

import com.nashakava.ui.component.HeaderComponent;
import com.nashakava.ui.elements.CartItemElement;
import com.nashakava.ui.page.MainPage;
import com.nashakava.ui.testrunners.BaseTestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartModalTest extends BaseTestRunner {

    @Test
    @Description("Verify functionality of product quantity controls (+, -) and removal (x) #5")
    @Feature("Cart Modal")
    @Issue("5")
    @Owner("Hrusha Nataliia")
    public void verifyQuantityControlsRemovalCounter() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        MainPage mainPage = new MainPage(driver);
        HeaderComponent header = mainPage
                .getCookiesModal()
                .clickOnAcceptCookiesButton()
                .getHeader();

        int initialCount = header.getTotalNumberFromHeaderCartCounter();
        softAssert.assertEquals(initialCount, 0, "Initial counter should be 0");

        header
                .clickOnCatalogButton()
                .navigateToCoffeeSection(mainPage)
                .getCoffeeCardByName("Brazil Decaf")
                .clickOnBuyButton();
        softAssert.assertEquals(mainPage.getNotificationPopUp().getAddedToCartNotificationText(), "Додано в кошик", "The message in the notification should be 'Додано в кошик'");
        int countAfterFirstAdding = header.getTotalNumberFromHeaderCartCounter();
        softAssert.assertEquals(countAfterFirstAdding, 1, "Count After First Adding should be 1");
        Thread.sleep(3000);
        CartItemElement cartItemElement= header.navigateToCartModal().findItemByName("Brazil Decaf");
        softAssert.assertEquals(cartItemElement.getItemNameText(), "Brazil Decaf");
        softAssert.assertEquals(cartItemElement.getItemDescriptionText(), "Турка, 100г");
        softAssert.assertEquals(cartItemElement.getItemQuantity().getAttribute("value"), "1");
    }
}
