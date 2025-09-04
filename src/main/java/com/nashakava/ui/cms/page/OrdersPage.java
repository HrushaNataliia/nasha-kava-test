package com.nashakava.ui.cms.page;

import com.nashakava.ui.cms.elements.OrderRowElement;
import com.nashakava.ui.cms.modal.ShippingDocumentModal;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class OrdersPage extends BaseCmsPage{

    @Getter
    public ShippingDocumentModal shippingDocumentModal;

    @Getter
    @FindBy(xpath = "//div[@class='flex min-w-full text-sm border-b border-surface-200 dark:border-surface-800 border-opacity-40 dark:border-opacity-40 hover:bg-opacity-95 cursor-pointer']")
    private List<WebElement> orderRows;

    @Getter
    @FindBy(xpath = "//div[@id='radix-:rr:']")
    private WebElement shippingDocumentModalRoot;




    public OrdersPage(WebDriver driver) {
        super(driver);
        shippingDocumentModal = new ShippingDocumentModal(driver, shippingDocumentModalRoot);

    }

    public List<OrderRowElement> getOrderRow() {
        waitUntilAllElementsVisible(orderRows);
        return orderRows.stream()
                .map(element -> new OrderRowElement(driver, element))
                .collect(Collectors.toList());
    }

    public OrderRowElement findItemById(String id) {
        waitUntilAllElementsVisible(orderRows);
        List<OrderRowElement> orderItems = getOrderRow();

        return orderItems.stream()
                .filter(orderRows -> {
                    String itemText = orderRows.getOrderId();
                    return itemText != null && itemText.contains(id);
                })
                .findFirst()
                .orElse(null);
    }

    @Step("Click on order with id: {orderId}")
    public ShippingDocumentModal clickOrderById(String orderId) {
        OrderRowElement orderElement = findItemById(orderId);
        clickDynamicElement(orderElement.getRootElement());
        return new ShippingDocumentModal(driver, shippingDocumentModalRoot);
    }
}
