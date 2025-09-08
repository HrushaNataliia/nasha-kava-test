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
    @Description("Verify functionality of product quantity controls (+, -) and removal (x)")
    @Feature("Cart Modal")
    @Issue("5")
    @Owner("Hrusha Nataliia")
    public void verifyQuantityControlsRemovalCounter() {
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
                .getCoffeeCardByName("Brazil Sul de Minas")
                .clickOnBuyButton();

        int countAfterFirstAdding = header.getTotalNumberFromHeaderCartCounter();
        softAssert.assertEquals(countAfterFirstAdding, 1, "Count After First Adding should be 1");

        mainPage.getNotificationPopUp().waitInvisibleCookiesNotification();
        mainPage.getNotificationPopUp().waitInvisibleAddedToCartNotificationText();

        header.navigateToCartModal(mainPage);

        CartItemElement cartItemElement = mainPage.getCartModal().findItemByName("Brazil Sul de Minas");

        softAssert.assertNotNull(cartItemElement, "Brazil Sul de Minas should be found in cart");
        softAssert.assertEquals(cartItemElement.getItemNameText(), "Brazil Sul de Minas",
                "Item name should match");
        softAssert.assertEquals(cartItemElement.getItemDescriptionText(), "Турка, 100г",
                "Item description should match");
        softAssert.assertEquals(cartItemElement.getItemQuantity().getAttribute("value"), "1",
                "Initial quantity should be 1");
        String itemPrice = cartItemElement.getItemPrice().getText();
        softAssert.assertTrue(itemPrice.contains("180"), "Price should be 180");
        String totalPrice = mainPage.getCartModal().getTotalPrice().getText();
        softAssert.assertTrue(totalPrice.contains("180"), "Total should be 180");

        cartItemElement.clickOnPlusButton();
        softAssert.assertEquals(header.getTotalNumberFromHeaderCartCounter(), 1,
                "Header count should remain 1");
        softAssert.assertEquals(cartItemElement.getItemQuantity().getAttribute("value"), "2",
                "Quantity should be 2 after clicking plus button");
        String itemPriceAfterAdding = cartItemElement.getItemPrice().getText();
        softAssert.assertTrue(itemPriceAfterAdding.contains("180"), "Price should still be 180");
        String totalPriceAfterAdding = mainPage.getCartModal().getTotalPrice().getText();
        softAssert.assertTrue(totalPriceAfterAdding.contains("360"), "Total should be 360");

        cartItemElement.clickOnMinusButton();
        softAssert.assertEquals(header.getTotalNumberFromHeaderCartCounter(), 1,
                "Header count should remain 1");
        softAssert.assertEquals(cartItemElement.getItemQuantity().getAttribute("value"), "1",
                "Quantity should be 1 after clicking minus button");
        String itemPriceAfterSubtraction = cartItemElement.getItemPrice().getText();
        softAssert.assertTrue(itemPriceAfterSubtraction.contains("180"), "Price should still be 180");
        String totalPriceAfterSubtraction = mainPage.getCartModal().getTotalPrice().getText();
        softAssert.assertTrue(totalPriceAfterSubtraction.contains("180"), "Total should be back to 180");

        cartItemElement.clickOnRemoveButton();

        softAssert.assertEquals(header.getTotalNumberFromHeaderCartCounter(), 0,
                "Header count should be 0 after removing item");

        softAssert.assertAll();
    }
}
