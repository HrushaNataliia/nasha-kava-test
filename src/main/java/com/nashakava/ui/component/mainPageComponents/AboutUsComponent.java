package com.nashakava.ui.component.mainPageComponents;

import com.nashakava.ui.component.BaseComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsComponent extends BaseComponent {
    @Getter
    @FindBy(xpath = ".//h2")
    private WebElement aboutUsHeader;

    public AboutUsComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public boolean isDisplayed() {
        waitUntilElementVisible(aboutUsHeader);
        return aboutUsHeader.isDisplayed();
    }
}
