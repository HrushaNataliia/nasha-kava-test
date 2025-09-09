package com.nashakava.ui;

import com.nashakava.ui.component.HeaderComponent;
import com.nashakava.ui.elements.deliveryRadioGroup.DeliveryRadioGroupEnum;
import com.nashakava.ui.page.CartPage;
import com.nashakava.ui.page.MainPage;
import com.nashakava.ui.page.OrderSuccessPage;
import com.nashakava.ui.testrunners.BaseTestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartPageTest extends BaseTestRunner {

    private static final String COFFEE_NAME = "Brazil Sul de Minas";
    private static final String CUSTOMER_NAME = "Auto CartPageTest";
    private static final String CUSTOMER_PHONE = "501234567";
    private static final String DELIVERY_COMMENT = "Доставити після 18:00";
    private static final String UKLON_ADDRESS = "м. Миколаїв, вул. Сінна 23";
    private static final String EXPECTED_SUCCESS_MESSAGE = "Дякуємо за Ваш вибір!";

    private static final int INITIAL_CART_COUNT = 0;
    private static final int COUNT_AFTER_ADDING = 1;


    @Test
    @Description("Verify successful order placement with valid contact, delivery, and payment details")
    @Feature("Cart Page")
    @Issue("11")
    @Owner("Hrusha Nataliia")
    public void verifySuccessfulOrderPlacementWithValidData() {
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

        CartPage cartPage = mainPage.getCartModal().clickOnMakeOrderButton();

        cartPage.getContactDetailsComponent()
                .enterName(CUSTOMER_NAME)
                .enterPhone(CUSTOMER_PHONE)
                .enterComment(DELIVERY_COMMENT);

        cartPage.getDeliveryComponent().getDeliveryRadioGroup().clickDeliveryRadioButton(DeliveryRadioGroupEnum.UKLON_TAXI);
        cartPage.getDeliveryComponent().enterAddressForUklon(UKLON_ADDRESS);

        cartPage.getPaymentComponent().clickOnBankTransferRadioButton();

        OrderSuccessPage orderSuccessPage = cartPage
                .getOrderComponent()
                .clickOnConfirmOrderButton();

        String successMessage = orderSuccessPage.getOrderSuccessMessageText();
        softAssert.assertEquals(successMessage, EXPECTED_SUCCESS_MESSAGE,
                "Order confirmation message should contain '" + EXPECTED_SUCCESS_MESSAGE + "'");

        MainPage redirectedMainPage = orderSuccessPage.clickOnToMainPageButton();

        softAssert.assertTrue(redirectedMainPage.getHeader().getLogoNashaKava().isDisplayed(),
                "User should be redirected to main page after clicking 'На головну'");

        softAssert.assertAll();
    }
}
