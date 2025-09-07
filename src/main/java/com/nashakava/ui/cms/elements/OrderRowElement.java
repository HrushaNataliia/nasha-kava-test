package com.nashakava.ui.cms.elements;

import com.nashakava.ui.cms.modal.ShippingDocumentModal;
import com.nashakava.ui.elements.BaseElement;
import com.nashakava.ui.page.MainPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderRowElement extends BaseElement {
    ShippingDocumentModal shippingDocumentModal;

    @Getter
    @FindBy(xpath = ".//span[@class='min-w-0 truncate text-center']")
    private WebElement orderId;


    @Getter
    @FindBy(xpath = ".//span[contains(@class,'material-icons') and contains(text(),'edit')]")
    private WebElement editButton;

    public OrderRowElement(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public String getOrderId() {
        return orderId.getText();
    }

    @Step("Click on Edit Button")
    public ShippingDocumentModal clickOnEditButton() {
        waitUntilElementClickable(editButton);
        editButton.click();
        return shippingDocumentModal;
    }



}
