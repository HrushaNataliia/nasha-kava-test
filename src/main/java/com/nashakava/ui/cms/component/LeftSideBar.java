package com.nashakava.ui.cms.component;

import com.nashakava.ui.component.BaseComponent;
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
}
