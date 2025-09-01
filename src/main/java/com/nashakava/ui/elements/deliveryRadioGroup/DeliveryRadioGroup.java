package com.nashakava.ui.elements.deliveryRadioGroup;
import com.nashakava.ui.component.BaseComponent;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.EnumMap;
import java.util.Map;

public class DeliveryRadioGroup extends BaseComponent {

    private final Map<DeliveryRadioGroupEnum, WebElement> deliveryRadioButtons = new EnumMap<>(DeliveryRadioGroupEnum.class);

    @Getter
    @FindBy(xpath = ".//input[@id='Самовивіз_з_нашого_магазину(м._Миколаїв,_вул._Сінна_23)_-_безкоштовно;']/../span[@class='checkmark']")
    private WebElement storePickupRadioButton;
    @Getter
    @FindBy(xpath = ".//input[@id='Таксі_Уклон_по_м._Миколаєву']/../span[@class='checkmark']")
    private WebElement uklonTaxiRadioButton;
    @Getter
    @FindBy(xpath = ".//input[@id='У_відділення_або_поштомат_Нової_Пошти;']/../span[@class='checkmark']")
    private WebElement novaPoshtaBranchRadioButton;
    @Getter
    @FindBy(xpath = ".//input[@id='Кур’єром_Нової_Пошти;']/../span[@class='checkmark']")
    private WebElement novaPoshtaCourierRadioButton;
    @Getter
    @FindBy(xpath = ".//input[@id='У_відділення_Укрпошти.']/../span[@class='checkmark']")
    private WebElement ukrposhtaBranchRadioButton;

    public DeliveryRadioGroup(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        initDeliveryRadioGroupMapper();
    }

    private void initDeliveryRadioGroupMapper() {
        deliveryRadioButtons.put(DeliveryRadioGroupEnum.STORE_PICKUP, storePickupRadioButton);
        deliveryRadioButtons.put(DeliveryRadioGroupEnum.UKLON_TAXI, uklonTaxiRadioButton);
        deliveryRadioButtons.put(DeliveryRadioGroupEnum.NOVA_POSHTA_BRANCH, novaPoshtaBranchRadioButton);
        deliveryRadioButtons.put(DeliveryRadioGroupEnum.NOVA_POSHTA_COURIER, novaPoshtaCourierRadioButton);
        deliveryRadioButtons.put(DeliveryRadioGroupEnum.UKR_POSHTA_BRANCH, ukrposhtaBranchRadioButton);
    }

    public String getDeliveryRadioGroupText(DeliveryRadioGroupEnum button) {
        return  deliveryRadioButtons.get(button).getText();
    }

    @Step("Click the Delivery Radio Button {button}")
    public DeliveryRadioGroup clickDeliveryRadioButton(DeliveryRadioGroupEnum button) {
        WebElement buttonElement = deliveryRadioButtons.get(button);
        scrollToElement(buttonElement);
        buttonElement.click();
        return this;
    }


}


