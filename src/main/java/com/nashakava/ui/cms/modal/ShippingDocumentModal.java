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

    @Getter
    @FindBy(xpath = ".//td[@data-testid='item-title']")
    private WebElement itemTitle;

    @Getter
    @FindBy(xpath = ".//td[@data-testid='item-desc']")
    private WebElement itemDescription;

    @Getter
    @FindBy(xpath = ".//td[@data-testid='item-cost']")
    private WebElement itemCost;

    @Getter
    @FindBy(xpath = ".//td[@data-testid='item-count']")
    private WebElement itemCount;

    @Getter
    @FindBy(xpath = ".//td[@data-testid='item-sum']")
    private WebElement itemSum;

    @Getter
    @FindBy(xpath = ".//td[@data-testid='total-sum']")
    private WebElement totalSum;


    public ShippingDocumentModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public String getOrderIdText() {
        waitUntilElementVisible(orderId);
        String fullText = orderId.getText();

        if (fullText.contains("Замовлення ")) {
            String[] words = fullText.split("\\s+");
            if (words.length > 1) {
                return words[1];
            }
        }
        return fullText;
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

    public String getItemTitleText() {
        return itemTitle.getText();
    }

    public String getItemDescriptionText() {
        return itemDescription.getText();
    }

    public String getItemCostText() {
        return itemCost.getText();
    }

    public String getItemCountText() {
        return itemCount.getText();
    }

    public String getItemSumText() {
        return itemSum.getText();
    }

    public String getTotalSumText() {
        return totalSum.getText();
    }
}
