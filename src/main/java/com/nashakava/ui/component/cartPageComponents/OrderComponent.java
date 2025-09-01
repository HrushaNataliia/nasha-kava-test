package com.nashakava.ui.component.cartPageComponents;

import com.nashakava.ui.component.BaseComponent;
import com.nashakava.ui.elements.CartItemElement;
import com.nashakava.ui.page.CartPage;
import com.nashakava.ui.page.MainPage;
import com.nashakava.ui.page.OrderSuccessPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class OrderComponent extends BaseComponent {
    @Getter
    @FindBy(xpath = ".//li[contains(@class, 'rounded')]")
    private List<WebElement> cartItemElements;

    @Getter
    @FindBy(xpath = ".//span[@class= 'text-title-h5 font-semibold']")
    private WebElement totalPrice;

    @Getter
    @FindBy(xpath = ".//a[@href= '/']")
    private WebElement continuePurchasesButton;

    @Getter
    @FindBy(xpath = ".//button[@aria-label= 'Підтвердити замовлення']")
    private WebElement confirmOrderButton;


    public OrderComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);

    }

    public List<CartItemElement> getCartItems() {
        waitUntilAllElementsVisible(cartItemElements);
        return cartItemElements.stream()
                .map(element -> new CartItemElement(driver, element))
                .collect(Collectors.toList());
    }

    public CartItemElement findItemByName(String itemName) {
        waitUntilAllElementsVisible(cartItemElements);
        List<CartItemElement> cartItems = getCartItems();

        return cartItems.stream()
                .filter(cartItemElement -> {
                    String itemText = cartItemElement.getItemNameText();
                    return itemText != null && itemText.contains(itemName);
                })
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

    @Step("Click on Confirm An Order Button")
    public OrderSuccessPage clickOnConfirmOrderButton() {
        scrollToElement(confirmOrderButton);
        waitUntilElementClickable(confirmOrderButton);
        confirmOrderButton.click();
        return new OrderSuccessPage(driver);
    }


}
