package com.nashakava.ui.elements.coffeeWeightOption;

import com.nashakava.ui.elements.BaseElement;
import com.nashakava.ui.elements.coffeeGrindDropdown.CoffeeGrindEnum;
import com.nashakava.ui.elements.deliveryRadioGroup.DeliveryRadioGroup;
import com.nashakava.ui.elements.deliveryRadioGroup.DeliveryRadioGroupEnum;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

public class CoffeeWeightElement extends BaseElement {

    private final Map<CoffeeWeightEnum, WebElement> coffeeWeight = new EnumMap<>(CoffeeWeightEnum.class);

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
        initCoffeeWeightMapper();
    }

    private void initCoffeeWeightMapper() {
        coffeeWeight.put(CoffeeWeightEnum.DRIP, dripButton);
        coffeeWeight.put(CoffeeWeightEnum.WEIGHT_100G, weight100gButton);
        coffeeWeight.put(CoffeeWeightEnum.WEIGHT_150G, weight150gButton);
        coffeeWeight.put(CoffeeWeightEnum.WEIGHT_250G, weight250gButton);
        coffeeWeight.put(CoffeeWeightEnum.WEIGHT_1KG, getWeight1kgButton());
    }

    public String getCoffeeWeightText(CoffeeWeightEnum button) {
        return  coffeeWeight.get(button).getText();
    }

    @Step("Click the Coffee Weight Button {button}")
    public CoffeeWeightElement clickCoffeeWeightButton(CoffeeWeightEnum button) {
        WebElement buttonElement = coffeeWeight.get(button);
        buttonElement.click();
        return this;
    }

}
