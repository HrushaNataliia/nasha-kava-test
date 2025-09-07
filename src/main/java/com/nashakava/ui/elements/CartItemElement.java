package com.nashakava.ui.elements;


import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartItemElement extends BaseElement {
    @Getter
    @FindBy(xpath = ".//p[@class= 'text-body-16s font-semibold']")
    private WebElement itemName;
    @Getter
    @FindBy(xpath = ".//p[@class= 'text-body-12r font-medium']")
    private WebElement itemDescription;
    @Getter
    @FindBy(xpath = ".//input[@aria-label= 'Кількість']")
    private WebElement itemQuantity;
    @Getter
    @FindBy(xpath = ".//p[@class= 'text-body-16s font-semibold text-nowrap']")
    private WebElement itemPrice;
    @Getter
    @FindBy(xpath = ".//button[@aria-label= 'Зменшити кількість']")
    private WebElement minusButton;
    @Getter
    @FindBy(xpath = ".//button[@aria-label= 'Збільшити кількість']")
    private WebElement plusButton;
    @Getter
    @FindBy(xpath = ".//button[@aria-label= 'Видалити з корзини']")
    private WebElement removeButton;

    public CartItemElement(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public String getItemNameText() {
        return itemName.getText();
    }

    public String getItemDescriptionText() {
        return itemDescription.getText();
    }

    @Step("Click on Minus Button")
    public CartItemElement clickOnMinusButton() {
        waitUntilElementClickable(minusButton);
        minusButton.click();
        return this;
    }

    @Step("Click on Plus Button")
    public CartItemElement clickOnPlusButton() {
        waitUntilElementClickable(plusButton);
        plusButton.click();
        return this;
    }

    @Step("Click on Remove Button")
    public CartItemElement clickOnRemoveButton() {
        waitUntilElementClickable(removeButton);
        removeButton.click();
        return this;
    }

}
