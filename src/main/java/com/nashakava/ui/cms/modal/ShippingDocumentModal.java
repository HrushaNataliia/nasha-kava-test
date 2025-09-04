package com.nashakava.ui.cms.modal;

import com.nashakava.ui.modal.BaseModal;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingDocumentModal extends BaseModal {

    @Getter
    @FindBy(xpath = ".//div[@class='px-3 md:px-4 lg-px-6 max-w-7xl m-auto mb-10 text-2xl font-bold text-center']")
    private WebElement orderId;

    @Getter
    @FindBy(xpath = ".//strong[contains(text(), 'Замовник')]/..")
    private WebElement name;

    @Getter
    @FindBy(xpath = ".//strong[contains(text(), 'Телефон')]/..")
    private WebElement phone;

    @Getter
    @FindBy(xpath = ".//strong[contains(text(), 'Коментар:')]/..")
    private WebElement comment;

    @Getter
    @FindBy(xpath = ".//strong[contains(text(), 'Тип доставки:')]/..")
    private WebElement deliveryType;

    @Getter
    @FindBy(xpath = ".//strong[contains(text(), 'Адреса:')]/..")
    private WebElement address;

    @Getter
    @FindBy(xpath = ".//strong[contains(text(), 'Оплата:')]/..")
    private WebElement payment;

    public ShippingDocumentModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public String getOrderIdText() {
        return orderId.getText();
    }

    public String getNameText() {
        return name.getText();
    }

    public String getPhoneText() {
        return phone.getText();
    }

    public String getCommentText() {
        return comment.getText();
    }

    public String getDeliveryTypeText() {
        return deliveryType.getText();
    }

    public String getAddressText() {
        return address.getText();
    }

    public String getPaymentText() {
        return payment.getText();
    }
}
