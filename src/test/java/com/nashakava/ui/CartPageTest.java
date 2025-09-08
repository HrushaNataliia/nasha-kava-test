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

    @Test
    @Description("Verify successful order placement with valid contact, delivery, and payment details")
    @Feature("Cart Page")
    @Issue("11")
    @Owner("Hrusha Nataliia")
    public void verifySuccessfulOrderPlacementWithValidData() throws InterruptedException {
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

        CartPage cartPage = mainPage.getCartModal().clickOnMakeOrderButton();
        Thread.sleep(3000);

        cartPage.getContactDetailsComponent()
                .enterName("Test User")
                .enterPhone("+380501234567")
                .enterComment("Доставити після 18:00");

        cartPage.getDeliveryComponent().getDeliveryRadioGroup().clickDeliveryRadioButton(DeliveryRadioGroupEnum.UKLON_TAXI);
        cartPage.getDeliveryComponent().enterAddressForUklon("м. Миколаїв, вул. Сінна 23");

        cartPage.getPaymentComponent().clickOnBankTransferRadioButton();

        OrderSuccessPage orderSuccessPage = cartPage
                .getOrderComponent()
                .clickOnConfirmOrderButton();

        String successMessage = orderSuccessPage.getOrderSuccessMessageText();
        softAssert.assertEquals(successMessage, "Дякуємо за Ваш вибір!",
                "Order confirmation message should contain 'Дякуємо за Ваш вибір!'");

        MainPage redirectedMainPage = orderSuccessPage.clickOnToMainPageButton();

        softAssert.assertTrue(redirectedMainPage.getHeader().getLogoNashaKava().isDisplayed(),
                "User should be redirected to main page after clicking 'На головну'");

        softAssert.assertAll();


    }
}
