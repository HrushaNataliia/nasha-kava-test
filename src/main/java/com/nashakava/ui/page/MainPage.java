package com.nashakava.ui.page;

import com.nashakava.ui.component.mainPageComponents.*;
import com.nashakava.ui.modal.CartModal;
import com.nashakava.ui.modal.CookiesModal;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @Getter
    public RelativeComponent relativeComponent;
    @Getter
    public AboutUsComponent aboutUsComponent;
    @Getter
    public CoffeeComponent coffeeComponent;
    @Getter
    public ForSoldiersComponent forSoldiersComponent;
    @Getter
    public SetsComponent setsComponent;
    @Getter
    public KomboochaComponent komboochaComponent;
    @Getter
    public ReviewsComponent reviewsComponent;
    @Getter
    public CargoAndPaymentComponent cargoAndPaymentComponent;
    @Getter
    public QuestionsComponent questionsComponent;
    @Getter
    public CartModal cartModal;
    @Getter
    public CookiesModal cookiesModal;

    @Getter
    @FindBy(xpath = "//section[@class= 'relative']")
    private WebElement relativeComponentRoot;
    @Getter
    @FindBy(xpath = "//section[@id= 'about-us']")
    private WebElement aboutUsComponentRoot;
    @Getter
    @FindBy(xpath = "//section[@id= 'coffee']")
    private WebElement coffeeComponentRoot;
    @Getter
    @FindBy(xpath = "//section[@id= 'forSoldiers']")
    private WebElement forSoldiersComponentRoot;
    @Getter
    @FindBy(xpath = "//section[@id= 'sets']")
    private WebElement setsComponentRoot;
    @Getter
    @FindBy(xpath = "//section[@id= 'komboocha']")
    private WebElement komboochaComponentRoot;
    @Getter
    @FindBy(xpath = "//section[@id= 'reviews']")
    private WebElement reviewsComponentRoot;
    @Getter
    @FindBy(xpath = "//section[@id= 'cargo-and-payment']")
    private WebElement cargoAndPaymentComponentRoot;
    @Getter
    @FindBy(xpath = "//section[contains(., 'Нас часто запитують')]")
    private WebElement questionsComponentRoot;
    @Getter
    @FindBy(xpath = "//div[@id='order-list']")
    private WebElement cartModalRoot;

    @Getter
    @FindBy(xpath = "//div[@class='container fixed bottom-0 left-[50%] -translate-y-5 -translate-x-[50%] z-[500] backdrop-blur-[2px]']")
    private WebElement cookiesModalRoot;

    public MainPage(WebDriver driver) {
        super(driver);
        relativeComponent = new RelativeComponent(driver, relativeComponentRoot);
        aboutUsComponent = new AboutUsComponent(driver, aboutUsComponentRoot);
        coffeeComponent = new CoffeeComponent(driver, coffeeComponentRoot);
        forSoldiersComponent = new ForSoldiersComponent(driver, forSoldiersComponentRoot);
        setsComponent = new SetsComponent(driver, setsComponentRoot);
        komboochaComponent = new KomboochaComponent(driver, komboochaComponentRoot);
        reviewsComponent = new ReviewsComponent(driver, reviewsComponentRoot);
        cargoAndPaymentComponent = new CargoAndPaymentComponent(driver, cargoAndPaymentComponentRoot);
        questionsComponent = new QuestionsComponent(driver, questionsComponentRoot);
        cartModal = new CartModal(driver, cartModalRoot);
        cookiesModal = new CookiesModal(driver,cookiesModalRoot);

    }

}
