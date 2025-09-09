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
    private static final String COFFEE_NAME = "Brazil Sul de Minas";
    private static final String EXPECTED_ITEM_DESCRIPTION = "Турка, 100г";
    private static final String EXPECTED_ITEM_PRICE = "180";
    private static final String EXPECTED_TOTAL_AFTER_PLUS = "360";
    private static final String QUANTITY_VALUE_ATTRIBUTE = "value";

    private static final int INITIAL_CART_COUNT = 0;
    private static final int COUNT_AFTER_ADDING = 1;
    private static final String INITIAL_QUANTITY = "1";
    private static final String QUANTITY_AFTER_PLUS = "2";
    private static final String QUANTITY_AFTER_MINUS = "1";
    private static final int FINAL_CART_COUNT = 0;

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
        softAssert.assertEquals(initialCount, INITIAL_CART_COUNT, "Initial counter should be 0");

        header
                .clickOnCatalogButton()
                .navigateToCoffeeSection(mainPage)
                .getCoffeeCardByName(COFFEE_NAME)
                .clickOnBuyButton();

        int countAfterFirstAdding = header.getTotalNumberFromHeaderCartCounter();
        softAssert.assertEquals(countAfterFirstAdding, COUNT_AFTER_ADDING, "Count After First Adding should be 1");

        mainPage.getNotificationPopUp().clickOnAcceptCookiesNotification();

        header.navigateToCartModal(mainPage);

        CartItemElement cartItemElement = mainPage.getCartModal().findItemByName(COFFEE_NAME);

        softAssert.assertNotNull(cartItemElement, COFFEE_NAME + " should be found in cart");
        softAssert.assertEquals(cartItemElement.getItemNameText(), COFFEE_NAME,
                "Item name should match");
        softAssert.assertEquals(cartItemElement.getItemDescriptionText(), EXPECTED_ITEM_DESCRIPTION,
                "Item description should match");
        softAssert.assertEquals(cartItemElement.getItemQuantity().getAttribute(QUANTITY_VALUE_ATTRIBUTE), INITIAL_QUANTITY,
                "Initial quantity should be 1");
        String itemPrice = cartItemElement.getItemPrice().getText();
        softAssert.assertTrue(itemPrice.contains(EXPECTED_ITEM_PRICE), "Price should be " + EXPECTED_ITEM_PRICE);
        String totalPrice = mainPage.getCartModal().getTotalPrice().getText();
        softAssert.assertTrue(totalPrice.contains(EXPECTED_ITEM_PRICE), "Total should be " + EXPECTED_ITEM_PRICE);

        cartItemElement.clickOnPlusButton();
        softAssert.assertEquals(header.getTotalNumberFromHeaderCartCounter(), COUNT_AFTER_ADDING,
                "Header count should remain 1");
        softAssert.assertEquals(cartItemElement.getItemQuantity().getAttribute(QUANTITY_VALUE_ATTRIBUTE), QUANTITY_AFTER_PLUS,
                "Quantity should be 2 after clicking plus button");
        String itemPriceAfterAdding = cartItemElement.getItemPrice().getText();
        softAssert.assertTrue(itemPriceAfterAdding.contains(EXPECTED_ITEM_PRICE), "Price should still be " + EXPECTED_ITEM_PRICE);
        String totalPriceAfterAdding = mainPage.getCartModal().getTotalPrice().getText();
        softAssert.assertTrue(totalPriceAfterAdding.contains(EXPECTED_TOTAL_AFTER_PLUS), "Total should be " + EXPECTED_TOTAL_AFTER_PLUS);

        cartItemElement.clickOnMinusButton();
        softAssert.assertEquals(header.getTotalNumberFromHeaderCartCounter(), COUNT_AFTER_ADDING,
                "Header count should remain 1");
        softAssert.assertEquals(cartItemElement.getItemQuantity().getAttribute(QUANTITY_VALUE_ATTRIBUTE), QUANTITY_AFTER_MINUS,
                "Quantity should be 1 after clicking minus button");
        String itemPriceAfterSubtraction = cartItemElement.getItemPrice().getText();
        softAssert.assertTrue(itemPriceAfterSubtraction.contains(EXPECTED_ITEM_PRICE), "Price should still be " + EXPECTED_ITEM_PRICE);
        String totalPriceAfterSubtraction = mainPage.getCartModal().getTotalPrice().getText();
        softAssert.assertTrue(totalPriceAfterSubtraction.contains(EXPECTED_ITEM_PRICE), "Total should be back to " + EXPECTED_ITEM_PRICE);

        cartItemElement.clickOnRemoveButton();

        softAssert.assertEquals(header.getTotalNumberFromHeaderCartCounter(), FINAL_CART_COUNT,
                "Header count should be 0 after removing item");

        softAssert.assertAll();
    }
}
