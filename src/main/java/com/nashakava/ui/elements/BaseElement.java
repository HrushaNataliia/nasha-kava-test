package com.nashakava.ui.elements;


import com.nashakava.ui.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public abstract class BaseElement extends Base {

    protected WebElement rootElement;

    public BaseElement(WebDriver driver, WebElement rootElement) {
        super(driver);
        this.rootElement = rootElement;
        PageFactory.initElements(new DefaultElementLocatorFactory(rootElement), this);
    }

    public WebElement getRootElement() {
        return rootElement;
    }

    public void click() {
        rootElement.click();
    }
}
