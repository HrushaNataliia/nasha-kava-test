package com.nashakava.ui.cms.elements;

import com.nashakava.ui.elements.BaseElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderRowElement extends BaseElement {

    @Getter
    @FindBy(xpath = ".//span[@class='min-w-0 truncate text-center']")
    private WebElement orderId;


    public OrderRowElement(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public String getOrderId() {
        return orderId.getText();
    }

}
