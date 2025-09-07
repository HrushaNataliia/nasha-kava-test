package com.nashakava.ui.page;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSuccessPage extends BasePage{

    @Getter
    @FindBy(xpath = "//h2[text()='Дякуємо за Ваш вибір!']")
    private WebElement orderSuccessMessage;

    @Getter
    @FindBy(xpath = "//a[text() = 'На головну']")
    private WebElement toMainPageButton;

    @Getter
    @FindBy(xpath = "//span[@class='text-[var(--coffee_accent)]']")
    private WebElement orderId;

    public OrderSuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getOrderSuccessMessageText() {
        waitUntilElementVisible(orderSuccessMessage);
        return orderSuccessMessage.getText();
    }

    @Step("Click on To Main Page Button")
    public MainPage clickOnToMainPageButton() {
        waitUntilElementClickable(toMainPageButton);
        toMainPageButton.click();
        return new MainPage(driver);
    }

    public String getOrderIdText() {
        waitUntilElementVisible(orderId);
        return orderId.getText();
    }

}
