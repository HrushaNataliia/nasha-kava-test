package com.nashakava.ui.cms.component;

import com.nashakava.ui.cms.page.BaseCmsPage;
import com.nashakava.ui.cms.page.OrdersPage;
import com.nashakava.ui.component.BaseComponent;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideBar extends BaseComponent {

    @Getter
    @FindBy(xpath = ".//a[@href='/c/orders']")
    private WebElement ordersButton;


    public LeftSideBar(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);

    }

    @Step("Click on Orders Button on Left Side Bar")
    public OrdersPage clickOnOrdersButton() {
        waitUntilElementClickable(ordersButton);
        ordersButton.click();
        return new OrdersPage(driver);
    }
}
