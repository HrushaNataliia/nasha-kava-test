package com.nashakava.ui.component.mainPageComponents;

import com.nashakava.ui.component.BaseComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetsComponent extends BaseComponent {
    @Getter
    @FindBy(xpath = ".//h2")
    private WebElement setsHeader;

    public SetsComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public boolean isDisplayed() {
        waitUntilElementVisible(setsHeader);
        return setsHeader.isDisplayed();
    }
}
