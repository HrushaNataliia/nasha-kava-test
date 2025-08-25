package com.nashakava.ui.component;

import com.nashakava.ui.component.mainPageComponents.AboutUsComponent;
import com.nashakava.ui.component.mainPageComponents.CargoAndPaymentComponent;
import com.nashakava.ui.component.mainPageComponents.RelativeComponent;
import com.nashakava.ui.elements.HeaderCatalogDropdown;
import com.nashakava.ui.page.CartPage;
import com.nashakava.ui.page.MainPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeaderComponent extends BaseComponent {
    @Getter
    public HeaderCatalogDropdown headerCatalogDropdown;

    @Getter
    @FindBy(xpath = ".//img[@alt='Логотип']")
    private WebElement logoNashaKava;

    @Getter
    @FindBy(xpath = ".//button[@aria-label='Вибрати товар в каталозі']")
    private WebElement catalogButton;

    @Getter
    @FindBy(xpath = ".//a[@href='/#about-us']")
    private WebElement aboutUsButton;

    @Getter
    @FindBy(xpath = ".//a[@href='/#cargo-and-payment']")
    private WebElement cargoAndPaymentButton;

    @Getter
    @FindBy(xpath = ".//a[@href='/#contacts']")
    private WebElement contactsButton;

    @Getter
    @FindBy(xpath = ".//button[@aria-label='Корзина']")
    private WebElement cartButton;

    @Getter
    @FindBy(xpath = ".//button[@aria-label='Корзина']/span")
    private WebElement cartCounter;

    @Getter
    @FindBy(xpath = ".//ul[@class='flex flex-col gap-1']")
    private WebElement catalogDropdownElementRoot;


    public HeaderComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        headerCatalogDropdown = new HeaderCatalogDropdown(driver, catalogDropdownElementRoot);
    }

    @Step("Click on Logo Nasha Kava in Header")
    public MainPage navigateToMainPage() {
        waitUntilElementClickable(logoNashaKava);
        logoNashaKava.click();
        return new MainPage(driver);
    }

    @Step("Click on Catalog Tab in Header")
    public HeaderCatalogDropdown clickOnCatalogButton() {
        waitUntilElementClickable(catalogButton);
        catalogButton.click();
        return new HeaderCatalogDropdown(driver, catalogDropdownElementRoot);
    }

    @Step("Click on About Us Tab in Header")
    public AboutUsComponent navigateToAboutUsSection(MainPage mainPage) {
        waitUntilElementClickable(aboutUsButton);
        aboutUsButton.click();
        scrollToElement(mainPage.getAboutUsComponentRoot());
        return new AboutUsComponent(driver, mainPage.getAboutUsComponentRoot());
    }

    @Step("Click on Cargo And Payment Tab in Header")
    public CargoAndPaymentComponent navigateToCargoAndPaymentSection(MainPage mainPage) {
        waitUntilElementClickable(cargoAndPaymentButton);
        cargoAndPaymentButton.click();
        scrollToElement(mainPage.getCargoAndPaymentComponentRoot());
        return new CargoAndPaymentComponent(driver, mainPage.getCargoAndPaymentComponentRoot());
    }

    @Step("Click on Contacts Tab in Header")
    public FooterComponent navigateToFooterViaContacts(MainPage mainPage) {
        waitUntilElementClickable(contactsButton);
        contactsButton.click();
        scrollToElement(mainPage.getFooterRoot());
        return new FooterComponent(driver, mainPage.getFooterRoot());
    }


    @Step("Click on Cart icon in Header")
    public CartPage navigateToCartModal() {
        waitUntilElementClickable(cartButton);
        cartButton.click();
        return new CartPage(driver);
    }


    public int getTotalNumberFromHeaderCartCounter() {
        String linkText = cartCounter.getText();
        Matcher match = Pattern.compile("(\\d+)").matcher(linkText);
        if (match.find()) {
            return Integer.parseInt(match.group());
        } else {
            return 0;
        }
    }
}
