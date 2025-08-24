package com.nashakava.ui.elements;

import com.nashakava.ui.component.mainPageComponents.AboutUsComponent;
import com.nashakava.ui.component.mainPageComponents.CoffeeComponent;
import com.nashakava.ui.component.mainPageComponents.KomboochaComponent;
import com.nashakava.ui.component.mainPageComponents.SetsComponent;
import com.nashakava.ui.page.MainPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderCatalogDropdown extends BaseElement {

    @Getter
    @FindBy(xpath = ".//a[@href='/#coffee']")
    private WebElement coffeeButton;

    @Getter
    @FindBy(xpath = ".//a[@href='/#sets']")
    private WebElement setsButton;

    @Getter
    @FindBy(xpath = ".//a[@href='/#komboocha']")
    private WebElement komboochaButton;

    public HeaderCatalogDropdown(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    @Step("Click on Coffee in Catalog Dropdown")
    public CoffeeComponent navigateToCoffeeSection(MainPage mainPage) {
        waitUntilElementClickable(coffeeButton);
        coffeeButton.click();
        scrollToElement(mainPage.getCoffeeComponentRoot());
        return new CoffeeComponent(driver, mainPage.getCoffeeComponentRoot());
    }

    @Step("Click on Sets in Catalog Dropdown")
    public SetsComponent navigateToSetsSection(MainPage mainPage) {
        waitUntilElementClickable(setsButton);
        setsButton.click();
        scrollToElement(mainPage.getSetsComponentRoot());
        return new SetsComponent(driver, mainPage.getSetsComponentRoot());
    }

    @Step("Click on Komboocha in Catalog Dropdown")
    public KomboochaComponent navigateToKomboochaSection(MainPage mainPage) {
        waitUntilElementClickable(komboochaButton);
        komboochaButton.click();
        scrollToElement(mainPage.getKomboochaComponentRoot());
        return new KomboochaComponent (driver, mainPage.getKomboochaComponentRoot());
    }
}
