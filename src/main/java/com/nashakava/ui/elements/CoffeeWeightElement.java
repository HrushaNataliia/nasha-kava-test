package com.nashakava.ui.elements;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoffeeWeightElement extends BaseElement {
    @Getter
    @FindBy(xpath = ".//button[contains(text(), 'Дріп')]")
    private WebElement dripButton;
    @Getter
    @FindBy(xpath = ".//button[contains(text(), '100г')]")
    private WebElement weight100gButton;
    @Getter
    @FindBy(xpath = ".//button[contains(text(), '150г')]")
    private WebElement weight150gButton;
    @Getter
    @FindBy(xpath = ".//button[contains(text(), '250г')]")
    private WebElement weight250gButton;
    @Getter
    @FindBy(xpath = ".//button[contains(text(), '1кг')]")
    private WebElement weight1kgButton;

    public CoffeeWeightElement(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    @Step("Select Drip coffee type")
    public CoffeeWeightElement selectDripCoffee() {
        waitUntilElementClickable(dripButton);
        dripButton.click();
        return this;
    }

    @Step("Select 100g weight option")
    public CoffeeWeightElement select100gWeight() {
        waitUntilElementClickable(weight100gButton);
        weight100gButton.click();
        return this;
    }

    @Step("Select 150g weight option")
    public CoffeeWeightElement select150gWeight() {
        waitUntilElementClickable(weight150gButton);
        weight150gButton.click();
        return this;
    }

    @Step("Select 250g weight option")
    public CoffeeWeightElement select250gWeight() {
        waitUntilElementClickable(weight250gButton);
        weight250gButton.click();
        return this;
    }

    @Step("Select 1kg weight option")
    public CoffeeWeightElement select1kgWeight() {
        waitUntilElementClickable(weight1kgButton);
        weight1kgButton.click();
        return this;
    }

}
