package com.nashakava.ui.page;

import com.nashakava.ui.component.cartPageComponents.ContactDetailsComponent;
import com.nashakava.ui.component.cartPageComponents.DeliveryComponent;
import com.nashakava.ui.component.cartPageComponents.OrderComponent;
import com.nashakava.ui.component.cartPageComponents.PaymentComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @Getter
    public ContactDetailsComponent contactDetailsComponent;
    @Getter
    public DeliveryComponent deliveryComponent;
    @Getter
    public PaymentComponent paymentComponent;
    @Getter
    public OrderComponent orderComponent;

    @Getter
    @FindBy(xpath = "//div[@class='flex flex-col gap-6 bg-bg-coffee-950 rounded-16 p-4']/p[text()='Контактні дані:']/..")
    private WebElement contactDetailsComponentRoot;
    @Getter
    @FindBy(xpath = "//div[@class='flex flex-col gap-6 bg-bg-coffee-950 rounded-16 p-4']/p[text()='Доставка:']/..")
    private WebElement deliveryComponentRoot;
    @Getter
    @FindBy(xpath = "//div[@class='flex flex-col gap-6 bg-bg-coffee-950 rounded-16 p-4']/p[text()='Оплата:']/..")
    private WebElement paymentComponentRoot;
    @Getter
    @FindBy(xpath = "//div[@class='flex flex-col w-full 2xl:w-[562px] bg-bg-coffee-950 rounded-16 p-4']")
    private WebElement orderComponentRoot;

    @Getter
    @FindBy(xpath = "//h1")
    private WebElement orderSuccessfullyPlacedMessage;

    @Getter
    @FindBy(xpath = "//a[text() = 'На головну']")
    private WebElement toMainPageButton;

    public CartPage(WebDriver driver) {
        super(driver);
        contactDetailsComponent = new ContactDetailsComponent(driver, contactDetailsComponentRoot);
        deliveryComponent = new DeliveryComponent(driver, deliveryComponentRoot);
        paymentComponent = new PaymentComponent(driver, paymentComponentRoot);
        orderComponent = new OrderComponent(driver, orderComponentRoot);
    }
}
