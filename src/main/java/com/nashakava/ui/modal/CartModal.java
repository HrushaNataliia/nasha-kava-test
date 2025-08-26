package com.nashakava.ui.modal;

import com.nashakava.ui.elements.CartItemElement;
import com.nashakava.ui.page.CartPage;
import com.nashakava.ui.page.MainPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartModal extends BaseModal{


    @Getter
    @FindBy(xpath = ".//li[contains(@class, 'rounded')]")
    private List<WebElement> cartItemElements;

    @Getter
    @FindBy(xpath = ".//span[@class= 'text-title-h5 font-semibold']")
    private WebElement totalPrice;

    @Getter
    @FindBy(xpath = ".//button[@aria-label= 'Продовжити покупки']")
    private WebElement continuePurchasesButton;

    @Getter
    @FindBy(xpath = ".//a[@href= '/order']")
    private WebElement makeOrderButton;

    public CartModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public List<CartItemElement> getCartItems() {
        return cartItemElements.stream()
                .map(element -> new CartItemElement(driver, element))
                .collect(Collectors.toList());
    }
    public CartItemElement findItemByName(String itemName) {
        return getCartItems().stream()
                .filter(shortItem -> shortItem.getItemNameText().contains(itemName))
                .findFirst()
                .orElse(null);
    }

    @Step("Click on Continue Purchases Button")
    public MainPage clickOnContinuePurchasesButton() {
        scrollToElement(continuePurchasesButton);
        waitUntilElementClickable(continuePurchasesButton);
        continuePurchasesButton.click();
        return new MainPage(driver);
    }

    @Step("Click on Make An Order Button")
    public CartPage clickOnMakeOrderButton() {
        scrollToElement(makeOrderButton);
        waitUntilElementClickable(makeOrderButton);
        makeOrderButton.click();
        return new CartPage(driver);
    }
}
