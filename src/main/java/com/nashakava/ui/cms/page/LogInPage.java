package com.nashakava.ui.cms.page;


import com.nashakava.ui.page.BasePage;
import com.nashakava.ui.page.CartPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogInPage extends BasePage {
    @Getter
    @FindBy(xpath = "//div[text()='Email/password']")
    private WebElement emailPasswordButton;

    @Getter
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @Getter
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @Getter
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Email Password Button")
    public LogInPage clickOnEmailPasswordButton() {
        waitUntilElementClickable(emailPasswordButton);
        emailPasswordButton.click();
        return this;
    }


}
