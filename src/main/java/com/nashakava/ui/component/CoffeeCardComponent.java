package com.nashakava.ui.component;

import com.nashakava.ui.elements.BaseElement;
import com.nashakava.ui.elements.CoffeeGrindDropdown;
import com.nashakava.ui.elements.CoffeeWeightElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoffeeCardComponent extends BaseComponent {
    @Getter
    public CoffeeGrindDropdown coffeeGrindDropdown;
    @Getter
    public CoffeeWeightElement coffeeWeightElement;

    @Getter
    @FindBy(xpath = ".//p[@class='text-title-h5 xs:text-title-h4 font-medium']")
    private WebElement coffeeName;
    @Getter
    @FindBy(xpath = ".//span[@class='text-title-h5 ']")
    private WebElement coffeePrice;
    @Getter
    @FindBy(xpath = ".//p[@class= 'text-body-14n font-normal']")
    private WebElement coffeeTaste;
    @Getter
    @FindBy(xpath = ".//button[@aria-label= 'Зменшити кількість']")
    private WebElement minusButton;
    @Getter
    @FindBy(xpath = ".//input[@aria-label= 'Кількість']")
    private WebElement coffeeQuantity;
    @Getter
    @FindBy(xpath = ".//button[@aria-label= 'Збільшити кількість']")
    private WebElement plusButton;
    @Getter
    @FindBy(xpath = ".//button[@aria-label='Купити кофе']")
    private WebElement buyButton;
    @Getter
    @FindBy(xpath = ".//button[@aria-label= 'Вибрати варіант помелу кави']")
    private WebElement coffeeGrindButton;

    @Getter
    @FindBy(xpath = ".//div[@class= 'absolute top-0 right-0 translate-y-[70px] z-10 w-[185px] p-2 rounded-12 bg-bg-white-850']")
    private WebElement coffeeGrindDropdownRoot;
    @Getter
    @FindBy(xpath = ".//div[@class= 'flex xs:items-center gap-3']")
    private WebElement coffeeWeightRoot;

    public CoffeeCardComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        coffeeWeightElement = new CoffeeWeightElement(driver, coffeeWeightRoot);

    }

    public String getCoffeeCardNameText() {
        return coffeeName.getText().split("\n")[0].trim();
    }

    @Step("Click On Coffee Grind Options to open Dropdown")
    public CoffeeGrindDropdown clickOnCoffeeGrindOptions() {
        waitUntilElementClickable(coffeeGrindButton);
        coffeeGrindButton.click();
        return new CoffeeGrindDropdown(driver, coffeeGrindDropdownRoot);
    }

    @Step("Click On Buy Button")
    public CoffeeCardComponent clickOnBuyButton() {
        scrollToElement(buyButton);
        waitUntilElementClickable(buyButton);
        buyButton.click();
        return this;
    }

}
