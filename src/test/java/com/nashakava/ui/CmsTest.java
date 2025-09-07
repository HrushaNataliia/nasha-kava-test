package com.nashakava.ui;

import com.nashakava.ui.cms.modal.ShippingDocumentModal;
import com.nashakava.ui.cms.page.LogInPage;
import com.nashakava.ui.component.HeaderComponent;
import com.nashakava.ui.elements.CartItemElement;
import com.nashakava.ui.elements.deliveryRadioGroup.DeliveryRadioGroupEnum;
import com.nashakava.ui.page.CartPage;
import com.nashakava.ui.page.MainPage;
import com.nashakava.ui.page.OrderSuccessPage;
import com.nashakava.ui.testrunners.BaseTestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CmsTest extends BaseTestRunner {

    private static final String COFFEE_NAME = "Brazil Decaf";
    private static final String CUSTOMER_NAME = "Test User";
    private static final String CUSTOMER_PHONE = "501234567";
    private static final String DELIVERY_COMMENT = "Доставити після 18:00";
    private static final String UKLON_ADDRESS = "м. Миколаїв, вул. Сінна 23";
    private static final String EXPECTED_SUCCESS_MESSAGE = "Дякуємо за Ваш вибір!";
    private static String ORDER_ID = "";
    private static final String EXPECTED_DELIVERY_TYPE = "Таксі Уклон по м. Миколаєву";
    private static final String EXPECTED_PAYMENT_TYPE = "Оплата на розрахунковий рахунок (Monobank)";

    private static String ITEM_TITLE = "";
    private static String ITEM_DESCRIPTION = "";
    private static String ITEM_COST = "";
    private static String ITEM_COUNT = "";
    private static String ITEM_SUM = "";
    private static String TOTAL_SUM = "";

    @Test
    @Description("Verify order is visible in CMS after successful placement")
    @Feature("E2E Order Flow")
    @Owner("Hrusha Nataliia")
    public void verifyOrderAppearsInCmsAfterPlacement() {
        SoftAssert softAssert = new SoftAssert();

        MainPage mainPage = new MainPage(driver);
        HeaderComponent header = mainPage
                .getCookiesModal()
                .clickOnAcceptCookiesButton()
                .getHeader();

        header.clickOnCatalogButton()
                .navigateToCoffeeSection(mainPage)
                .getCoffeeCardByName(COFFEE_NAME)
                .clickOnBuyButton();

        mainPage.getNotificationPopUp().waitInvisibleCookiesNotification();
        mainPage.getNotificationPopUp().waitInvisibleAddedToCartNotificationText();

        header.navigateToCartModal(mainPage);

        CartItemElement cartItemElement = mainPage.getCartModal().findItemByName(COFFEE_NAME);
        ITEM_TITLE = cartItemElement.getItemNameText();
        ITEM_DESCRIPTION = cartItemElement.getItemDescriptionText();
        ITEM_COST = cartItemElement.getItemPrice().getText().replaceAll("[^0-9]", "");
        ITEM_COUNT = cartItemElement.getItemQuantity().getAttribute("value");
        ITEM_SUM = cartItemElement.getItemPrice().getText().replaceAll("[^0-9]", "");
        TOTAL_SUM = mainPage.getCartModal().getTotalPrice().getText().replaceAll("[^0-9]", "");


        CartPage cartPage = mainPage.getCartModal().clickOnMakeOrderButton();
        cartPage.getContactDetailsComponent()
                .enterName(CUSTOMER_NAME)
                .enterPhone(CUSTOMER_PHONE)
                .enterComment(DELIVERY_COMMENT);

        cartPage.getDeliveryComponent().getDeliveryRadioGroup()
                .clickDeliveryRadioButton(DeliveryRadioGroupEnum.UKLON_TAXI);
        cartPage.getDeliveryComponent()
                .enterAddressForUklon(UKLON_ADDRESS);
        cartPage.getPaymentComponent()
                .clickOnBankTransferRadioButton();

        OrderSuccessPage orderSuccessPage = cartPage.getOrderComponent()
                .clickOnConfirmOrderButton();

        softAssert.assertEquals(
                orderSuccessPage.getOrderSuccessMessageText(),
                EXPECTED_SUCCESS_MESSAGE,
                "Success message should be shown"
        );

        ORDER_ID = orderSuccessPage.getOrderIdText();

        driver.get(testValueProvider.getCmsUIUrl());

        LogInPage loginPage = new LogInPage(driver);
        ShippingDocumentModal shippingDocumentModal = loginPage
                .clickOnEmailPasswordButton()
                .enterEmail(testValueProvider.getAdminEmail())
                .clickOnNextButton()
                .enterPassword(testValueProvider.getAdminPassword())
                .clickOnLoginButton()
                .getLeftSideBar()
                .clickOnOrdersButton()
                .clickOrderById(ORDER_ID);

        softAssert.assertTrue(
                shippingDocumentModal.getOrderIdText().contains(ORDER_ID),
                "Order ID in shipping document should match table. Document: " +
                        shippingDocumentModal.getOrderIdText() + ", Table: " +ORDER_ID
        );

        softAssert.assertTrue(
                shippingDocumentModal.getNameText().contains(CUSTOMER_NAME),
                "Customer name should match. Expected: " + CUSTOMER_NAME +
                        ", Actual: " + shippingDocumentModal.getNameText()
        );

        softAssert.assertTrue(
                shippingDocumentModal.getPhoneText().contains(CUSTOMER_PHONE),
                "Phone number should match. Expected: " + CUSTOMER_PHONE +
                        ", Actual: " + shippingDocumentModal.getPhoneText()
        );

        softAssert.assertTrue(
                shippingDocumentModal.getCommentText().contains(DELIVERY_COMMENT),
                "Delivery comment should match. Expected: " + DELIVERY_COMMENT +
                        ", Actual: " + shippingDocumentModal.getCommentText()
        );

        softAssert.assertTrue(
                shippingDocumentModal.getDeliveryTypeText().contains(EXPECTED_DELIVERY_TYPE),
                "Delivery type should match. Expected: " + EXPECTED_DELIVERY_TYPE +
                        ", Actual: " + shippingDocumentModal.getDeliveryTypeText()
        );

        softAssert.assertTrue(
                shippingDocumentModal.getAddressText().contains(UKLON_ADDRESS),
                "Address should match. Expected: " + UKLON_ADDRESS +
                        ", Actual: " + shippingDocumentModal.getAddressText()
        );

        softAssert.assertTrue(
                shippingDocumentModal.getPaymentText().contains(EXPECTED_PAYMENT_TYPE),
                "Payment type should match. Expected: " + EXPECTED_PAYMENT_TYPE +
                        ", Actual: " + shippingDocumentModal.getPaymentText()
        );

        softAssert.assertTrue(
                shippingDocumentModal.getItemTitleText().contains(ITEM_TITLE),
                "Item title should match. Expected: " + ITEM_TITLE +
                        ", Actual: " + shippingDocumentModal.getItemTitleText()
        );

        String actualDescription = shippingDocumentModal.getItemDescriptionText();
        boolean descriptionMatches = actualDescription.contains("100г") && actualDescription.contains("Турка");
        softAssert.assertTrue(
                descriptionMatches,
                "Item description should contain '100г' and 'Турка'. Expected from cart: " + ITEM_DESCRIPTION +
                        ", Actual in CMS: " + actualDescription
        );

        softAssert.assertTrue(
                shippingDocumentModal.getItemCostText().contains(ITEM_COST),
                "Item cost should match. Expected: " + ITEM_COST +
                        ", Actual: " + shippingDocumentModal.getItemCostText()
        );

        softAssert.assertTrue(
                shippingDocumentModal.getItemCountText().contains(ITEM_COUNT),
                "Item count should match. Expected: " + ITEM_COUNT +
                        ", Actual: " + shippingDocumentModal.getItemCountText()
        );

        softAssert.assertTrue(
                shippingDocumentModal.getItemSumText().contains(ITEM_SUM),
                "Item sum should match. Expected: " + ITEM_SUM +
                        ", Actual: " + shippingDocumentModal.getItemSumText()
        );

        softAssert.assertTrue(
                shippingDocumentModal.getTotalSumText().contains(TOTAL_SUM),
                "Total sum should match. Expected: " + TOTAL_SUM +
                        ", Actual: " + shippingDocumentModal.getTotalSumText()
        );


        softAssert.assertAll();
    }
}
