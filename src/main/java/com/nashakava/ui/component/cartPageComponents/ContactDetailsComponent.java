package com.nashakava.ui.component.cartPageComponents;

import com.nashakava.ui.component.BaseComponent;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetailsComponent extends BaseComponent {
    @Getter
    @FindBy(xpath = ".//input[@name='name']")
    private WebElement nameInput;
    @Getter
    @FindBy(xpath = ".//span[@class='absolute right-0 bottom-0 translate-y-[16px] text-[var(--coffee_accent)] text-body-12r font-medium']")
    private WebElement nameErrorMessage;
    @Getter
    @FindBy(xpath = ".//input[@name='phone']")
    private WebElement phoneInput;
    @Getter
    @FindBy(xpath = ".//span[@class='block absolute right-0 bottom-0 translate-y-[15px] text-[var(--coffee_accent)] text-body-12r font-medium']")
    private WebElement phoneErrorMessage;
    @Getter
    @FindBy(xpath = ".//textarea[@name='comment']")
    private WebElement commentInput;
    @Getter
    @FindBy(xpath = ".//span[@class='block absolute right-0 bottom-0 translate-y-[12px] text-[var(--coffee_accent)] text-body-12r font-medium']")
    private WebElement commentErrorMessage;

    public ContactDetailsComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
    }

    public String getNameErrorMessageText() {
        return nameErrorMessage.getText();
    }

    public String getPhoneErrorMessageText() {
        return phoneErrorMessage.getText();
    }

    public String getCommentErrorMessageText() {
        return commentErrorMessage.getText();
    }

    @Step("Set Name Input {name}")
    public ContactDetailsComponent enterName(String name) {
        waitUntilElementVisible(nameInput);
        nameInput.sendKeys(name);
        return this;
    }

    @Step("Set Phone Input {phone}")
    public ContactDetailsComponent enterPhone(String phone) {
        waitUntilElementVisible(phoneInput);
        phoneInput.sendKeys(phone);
        return this;
    }

    @Step("Set Comment Input {comment}")
    public ContactDetailsComponent enterComment(String comment) {
        waitUntilElementVisible(commentInput);
        commentInput.sendKeys(comment);
        return this;
    }

}
