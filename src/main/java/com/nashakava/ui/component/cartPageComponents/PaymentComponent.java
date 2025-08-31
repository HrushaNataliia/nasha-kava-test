package com.nashakava.ui.component.cartPageComponents;

import com.nashakava.ui.component.BaseComponent;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentComponent extends BaseComponent {
    @Getter
    @FindBy(xpath = ".//input[@id='Оплата_на_розрахунковий_рахунок_(Monobank);']")
    private WebElement bankTransferRadioButton;
    @Getter
    @FindBy(xpath = ".//input[@id='Накладеним_платежем_(2_%_від_суми_+_20_грн,_згідно_з_тарифами_Нової_Пошти).']")
    private WebElement cashOnDeliveryRadioButton;

    public PaymentComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    @Step("Click on Bank Transfer Radio Button")
    public PaymentComponent clickOnBankTransferRadioButton() {
        waitUntilElementClickable(bankTransferRadioButton);
        bankTransferRadioButton.click();
        return this;
    }

    @Step("Click on Cash On Delivery Radio Button")
    public PaymentComponent clickOnCashOnDeliveryRadioButton() {
        waitUntilElementClickable(cashOnDeliveryRadioButton);
        cashOnDeliveryRadioButton.click();
        return this;
    }
}
