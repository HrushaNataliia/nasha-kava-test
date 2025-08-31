package com.nashakava.ui.component.cartPageComponents;

import com.nashakava.ui.component.BaseComponent;
import com.nashakava.ui.elements.deliveryRadioGroup.DeliveryRadioGroup;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryComponent extends BaseComponent {
    @Getter
    public DeliveryRadioGroup deliveryRadioGroup;

    @Getter
    @FindBy(xpath = ".//div[@aria-labelledby='Спосіб Доставки']")
    private WebElement deliveryRadioGroupRoot;
    @Getter
    @FindBy(xpath = ".//input[@name='uklon']")
    private WebElement uklonInput;

    @Getter
    @FindBy(xpath = ".//input[@name='city']")
    private WebElement cityNovaPoshtaInput;
    @Getter
    @FindBy(xpath = ".//input[@name='novaPoshta']")
    private WebElement branchNovaPoshtaInput;
    @Getter
    @FindBy(xpath = ".//input[@name='courier']")
    private WebElement addressForCourierNovaPoshtaInput;
    @Getter
    @FindBy(xpath = ".//input[@name='ukrPoshta']")
    private WebElement ukrPoshtaInput;

    @Getter
    @FindBy(xpath = ".//span[text()='Обовʼязкове поле']")
    private WebElement deliveryErrorMessage;

    public DeliveryComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        deliveryRadioGroup = new DeliveryRadioGroup (driver, deliveryRadioGroupRoot);
    }

    @Step("Set Address For Uklon {address}")
    public DeliveryComponent enterAddressForUklon(String address) {
        waitUntilElementVisible(uklonInput);
        uklonInput.sendKeys(address);
        return this;
    }

    @Step("Set City For Nova Poshta {city}")
    public DeliveryComponent enterCityForNovaPoshta(String city) {
        waitUntilElementVisible(cityNovaPoshtaInput);
        cityNovaPoshtaInput.sendKeys(city);
        return this;
    }

    @Step("Set Address For Courier Nova Poshta {address}")
    public DeliveryComponent enterAddressForCourierNovaPoshta(String address) {
        waitUntilElementVisible(addressForCourierNovaPoshtaInput);
        addressForCourierNovaPoshtaInput.sendKeys(address);
        return this;
    }

    @Step("Set Address For Ukr Poshta {address}")
    public DeliveryComponent enterAddressForUkrPoshta(String address) {
        waitUntilElementVisible(ukrPoshtaInput);
        ukrPoshtaInput.sendKeys(address);
        return this;
    }




}
