package com.nashakava.ui.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationPopUp extends BaseElement{
    @Getter
    @FindBy(xpath = ".//div[@id='NotiflixNotify-1']/span")
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
}
