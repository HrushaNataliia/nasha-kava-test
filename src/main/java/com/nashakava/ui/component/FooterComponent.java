package com.nashakava.ui.component;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterComponent extends BaseComponent {
    @Getter
    @FindBy(xpath = ".//a[@aria-label= 'instagram']")
    private WebElement instagramIcon;

    public FooterComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public boolean isDisplayed() {
        waitUntilElementVisible(instagramIcon);
        return instagramIcon.isDisplayed();
    }
}
