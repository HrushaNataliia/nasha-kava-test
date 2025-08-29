package com.nashakava.ui.modal;

import com.nashakava.ui.page.MainPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiesModal extends BaseModal {
    @Getter
    @FindBy(xpath = "//button[@aria-label='Погодитись з cookies']")
    private WebElement acceptCookiesButton;

    public CookiesModal(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    @Step("Click on Accept Cookies Button")
    public MainPage clickOnAcceptCookiesButton() {
        waitUntilElementClickable(acceptCookiesButton);
        acceptCookiesButton.click();
        return new MainPage(driver);
    }





}
