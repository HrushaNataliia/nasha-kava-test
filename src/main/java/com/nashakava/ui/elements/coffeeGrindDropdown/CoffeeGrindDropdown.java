package com.nashakava.ui.elements.coffeeGrindDropdown;

import com.nashakava.ui.elements.BaseElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

public class CoffeeGrindDropdown extends BaseElement {

    private final Map<CoffeeGrindEnum, WebElement> coffeeGrind= new EnumMap<>(CoffeeGrindEnum.class);

    @Getter
    @FindBy(xpath = ".//li[contains(text(), 'Турка')]")
    private WebElement turkishGrindOption;
    @Getter
    @FindBy(xpath = ".//li[contains(text(), 'Чашка')]")
    private WebElement cupGrindOption;
    @Getter
    @FindBy(xpath = ".//li[contains(text(), 'Еспресо')]")
    private WebElement espressoGrindOption;
    @Getter
    @FindBy(xpath = ".//li[contains(text(), 'Гейзер')]")
    private WebElement mokaPotGrindOption;
    @Getter
    @FindBy(xpath = ".//li[contains(text(), 'Фільтр (крапельна)')]")
    private WebElement dripFilterGrindOption;
    @Getter
    @FindBy(xpath = ".//li[contains(text(), 'Пуровер')]")
    private WebElement pourOverGrindOption;
    @Getter
    @FindBy(xpath = ".//li[contains(text(), 'Кемекс')]")
    private WebElement chemexGrindOption;
    @Getter
    @FindBy(xpath = ".//li[contains(text(), 'Френч-прес')]")
    private WebElement frenchPressGrindOption;
    @Getter
    @FindBy(xpath = ".//li[contains(text(), 'Колдбрю')]")
    private WebElement coldBrewGrindOption;

    public CoffeeGrindDropdown(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        initCoffeeGrindMapper();
    }

    private void initCoffeeGrindMapper() {
        coffeeGrind.put(CoffeeGrindEnum.TURKISH_GRIND, turkishGrindOption);
        coffeeGrind.put(CoffeeGrindEnum.CUP_GRIND, cupGrindOption);
        coffeeGrind.put(CoffeeGrindEnum.ESPRESSO_GRIND, espressoGrindOption);
        coffeeGrind.put(CoffeeGrindEnum.MOKA_POT_GRIND, mokaPotGrindOption);
        coffeeGrind.put(CoffeeGrindEnum.DRIP_FILTER_GRIND, dripFilterGrindOption);
        coffeeGrind.put(CoffeeGrindEnum.POUROVER_GRIND, pourOverGrindOption);
        coffeeGrind.put(CoffeeGrindEnum.CHEMEX_GRIND, chemexGrindOption);
        coffeeGrind.put(CoffeeGrindEnum.FRENCH_PRESS_GRIND, frenchPressGrindOption);
        coffeeGrind.put(CoffeeGrindEnum.COLD_BREW_GRIND, coldBrewGrindOption);
    }

    public String getCoffeeGrindText(CoffeeGrindEnum grind) {
        return   coffeeGrind.get(grind).getText();
    }

    @Step("Select the {grind} In Coffee Grind Dropdown")
    public CoffeeGrindDropdown selectGrind(CoffeeGrindEnum grind) {
        WebElement grindElement = coffeeGrind.get(grind);
        grindElement.click();
        return this;
    }


}
