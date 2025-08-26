package com.nashakava.ui.elements;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoffeeGrindDropdown extends BaseElement {

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
    }

    @Step("Select Turkish grind option")
    public CoffeeGrindDropdown selectTurkishGrind() {
        waitUntilElementClickable(turkishGrindOption);
        turkishGrindOption.click();
        return this;
    }

    @Step("Select Cup grind option")
    public CoffeeGrindDropdown selectCupGrind() {
        waitUntilElementClickable(cupGrindOption);
        cupGrindOption.click();
        return this;
    }

    @Step("Select Espresso grind option")
    public CoffeeGrindDropdown selectEspressoGrind() {
        waitUntilElementClickable(espressoGrindOption);
        espressoGrindOption.click();
        return this;
    }

    @Step("Select Moka Pot grind option")
    public CoffeeGrindDropdown selectMokaPotGrind() {
        waitUntilElementClickable(mokaPotGrindOption);
        mokaPotGrindOption.click();
        return this;
    }

    @Step("Select Drip Filter grind option")
    public CoffeeGrindDropdown selectDripFilterGrind() {
        waitUntilElementClickable(dripFilterGrindOption);
        dripFilterGrindOption.click();
        return this;
    }

    @Step("Select Pour Over grind option")
    public CoffeeGrindDropdown selectPourOverGrind() {
        waitUntilElementClickable(pourOverGrindOption);
        pourOverGrindOption.click();
        return this;
    }

    @Step("Select Chemex grind option")
    public CoffeeGrindDropdown selectChemexGrind() {
        waitUntilElementClickable(chemexGrindOption);
        chemexGrindOption.click();
        return this;
    }

    @Step("Select French Press grind option")
    public CoffeeGrindDropdown selectFrenchPressGrind() {
        waitUntilElementClickable(frenchPressGrindOption);
        frenchPressGrindOption.click();
        return this;
    }

    @Step("Select Cold Brew grind option")
    public CoffeeGrindDropdown selectColdBrewGrind() {
        waitUntilElementClickable(coldBrewGrindOption);
        coldBrewGrindOption.click();
        return this;
    }
}
