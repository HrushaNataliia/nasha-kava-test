package com.nashakava.ui.elements;

import com.nashakava.ui.page.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationPopUp extends BaseElement{

    @Getter
    @FindBy(xpath = ".//div[@id='NotiflixNotify-1' ]/span[contains(text(),'Дякуємо за згоду')]")
    private WebElement acceptCookiesNotification;

    @Getter
    @FindBy(xpath = ".//div[@id='NotiflixNotify-1' ]/span[contains(text(),'Додано в кошик')]")
    private WebElement addedToCartNotification;

    @Getter
    @FindBy(xpath = ".//div[@id='NotiflixNotify-2']/span")
    private WebElement removalFromCartNotification;

    public NotificationPopUp(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public String getAddedToCartNotificationText(){
        waitUntilElementVisible(addedToCartNotification);
        return addedToCartNotification.getText();
    }

    public String getRemovalFromCartNotificationText(){
        waitUntilElementVisible(removalFromCartNotification);
        return removalFromCartNotification.getText();
    }


    public void waitInvisibleCookiesNotification(){
        waitUntilElementInvisible(acceptCookiesNotification);

    }

    public void waitInvisibleAddedToCartNotificationText(){
        waitUntilElementInvisible(addedToCartNotification);
    }

    @Step("Click on Accept Cookies Notification ")
    public NotificationPopUp clickOnAcceptCookiesNotification() {
        waitUntilElementClickable(acceptCookiesNotification);
        acceptCookiesNotification.click();
        return this;
    }

    @Step("Click on Added To Cart Notification")
    public NotificationPopUp clickOnAddedToCartNotification() {
        waitUntilElementClickable(addedToCartNotification);
        addedToCartNotification.click();
        return this;
    }

    @Step("Click on Removal From Cart Notification")
    public NotificationPopUp clickOnRemovalFromCartNotification() {
        waitUntilElementClickable(removalFromCartNotification);
        removalFromCartNotification.click();
        return this;
    }





}
