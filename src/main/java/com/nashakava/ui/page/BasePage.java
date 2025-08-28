package com.nashakava.ui.page;


import com.nashakava.ui.Base;
import com.nashakava.ui.component.FooterComponent;
import com.nashakava.ui.component.HeaderComponent;
import com.nashakava.ui.elements.NotificationPopUp;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;


public abstract class BasePage extends Base {
    @Getter
    public HeaderComponent header;
    @Getter
    public FooterComponent footer;
    @Getter
    public NotificationPopUp notificationPopUp;

    @Getter
    @FindBy(xpath = "//header[contains(@class, 'container') and contains(@class, 'sticky')]")
    private WebElement headerRoot;

    @Getter
    @FindBy(xpath = "//footer[@id ='contacts']")
    private WebElement footerRoot;

    @Getter
    @FindBy(xpath = "//div[@id='NotiflixNotifyWrap']")
    private WebElement notificationPopUpRoot;

    public BasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver, headerRoot);
        footer = new FooterComponent(driver, footerRoot);
        notificationPopUp = new NotificationPopUp(driver, notificationPopUpRoot);

    }

    @Step("Retrieve the full content height of the page")
    private int getContentHeight() {
        return ((Number) Objects.requireNonNull(threadJs.executeScript("return document.body.scrollHeight;"))).intValue();
    }

    @Step("Wait for the page to load within {0} seconds")
    public void waitForPageToLoad(long timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    @Step("Check if element is invisible: {0}")
    public Boolean isElementInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
