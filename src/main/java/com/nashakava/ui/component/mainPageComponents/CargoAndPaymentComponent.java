package com.nashakava.ui.component.mainPageComponents;

import com.nashakava.ui.component.BaseComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CargoAndPaymentComponent extends BaseComponent {
    @Getter
    @FindBy(xpath = ".//h2")
    private WebElement cargoAndPaymentHeader;

    public CargoAndPaymentComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public boolean isDisplayed() {
        waitUntilElementVisible(cargoAndPaymentHeader);
        return cargoAndPaymentHeader.isDisplayed();
    }
}
