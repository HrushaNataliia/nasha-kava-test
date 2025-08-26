package com.nashakava.ui.component.mainPageComponents;

import com.nashakava.ui.component.BaseComponent;
import com.nashakava.ui.component.CoffeeCardComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CoffeeComponent extends BaseComponent {

    @Getter
    @FindBy(xpath = ".//h2")
    private WebElement coffeeHeader;

    @Getter
    private List<CoffeeCardComponent> coffeeCards = new ArrayList<>();

    @Getter
    @FindBy(xpath = ".//div[@class='flex flex-col gap-4 pt-[40px] lg:pt-[60px]']")
    private List<WebElement> coffeeCardComponentRoot;

    public CoffeeComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        for (WebElement card : coffeeCardComponentRoot) {
            coffeeCards.add(new CoffeeCardComponent(driver, card));
        }
    }

    public boolean isDisplayed() {
        waitUntilElementVisible(coffeeHeader);
        return coffeeHeader.isDisplayed();
    }

    public CoffeeCardComponent getCoffeeCardByName(String coffeeName) {
        return coffeeCards.stream()
                .filter(c -> c.getCoffeeCardNameText().equals(coffeeName))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException("Card with name " + coffeeName + " not found"));
    }
}
