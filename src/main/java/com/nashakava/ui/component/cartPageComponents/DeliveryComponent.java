package com.nashakava.ui.component.cartPageComponents;

import com.nashakava.ui.component.BaseComponent;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryComponent extends BaseComponent {

    @Getter
    @FindBy(xpath = ".//input[@id='Самовивіз_з_нашого_магазину(м._Миколаїв,_вул._Сінна_23)_-_безкоштовно;']")
    private WebElement storePickupRadioButton;
    @Getter
    @FindBy(xpath = ".//input[@id='Таксі_Уклон_по_м._Миколаєву']")
    private WebElement uklonTaxiRadioButton;
    @Getter
    @FindBy(xpath = ".//input[@id='У_відділення_або_поштомат_Нової_Пошти;']")
    private WebElement novaPoshtaBranchRadioButton;
    @Getter
    @FindBy(xpath = ".//input[@id='Кур’єром_Нової_Пошти;']")
    private WebElement novaPoshtaCourierRadioButton;
    @Getter
    @FindBy(xpath = ".//input[@id='У_відділення_Укрпошти.']")
    private WebElement ukrposhtaBranchRadioButton;


    public DeliveryComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    @Step("Click on Store Pickup Radio Button")
    public DeliveryComponent clickOnStorePickupRadioButton() {
        waitUntilElementClickable(storePickupRadioButton);
        storePickupRadioButton.click();
        return this;
    }

    @Step("Click on Uklon Taxi Radio Button")
    public DeliveryComponent clickOnUklonTaxiRadioButton() {
        waitUntilElementClickable(uklonTaxiRadioButton);
        uklonTaxiRadioButton.click();
        return this;
    }

    @Step("Click on Nova Poshta Branch Radio Button")
    public DeliveryComponent clickOnNovaPoshtaBranchRadioButton() {
        waitUntilElementClickable(novaPoshtaBranchRadioButton);
        novaPoshtaBranchRadioButton.click();
        return this;
    }

    @Step("Click on Nova Poshta Courier Radio Button")
    public DeliveryComponent clickOnNovaPoshtaCourierRadioButton() {
        waitUntilElementClickable(novaPoshtaCourierRadioButton);
        novaPoshtaCourierRadioButton.click();
        return this;
    }

    @Step("Click on Ukrposhta Branch Radio Button")
    public DeliveryComponent clickOnUkrposhtaBranchRadioButton() {
        waitUntilElementClickable(ukrposhtaBranchRadioButton);
        ukrposhtaBranchRadioButton.click();
        return this;
    }


}
