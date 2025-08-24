package com.nashakava.ui;

import com.nashakava.ui.component.HeaderComponent;
import com.nashakava.ui.component.mainPageComponents.AboutUsComponent;
import com.nashakava.ui.component.mainPageComponents.CargoAndPaymentComponent;
import com.nashakava.ui.elements.HeaderCatalogDropdown;

import com.nashakava.ui.page.MainPage;
import com.nashakava.ui.testrunners.BaseTestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HeaderSmokeTest extends BaseTestRunner {

    @Test
    @Description("Verify Navigation From All Tabs In Header.")
    @Feature("Header")
    @Owner("Hrusha Nataliia")
    public void verifyNavigationFromAllTabsInHeader() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        MainPage mainPage = new MainPage(driver);
        HeaderComponent header = mainPage.getHeader();

        //Coffee
        HeaderCatalogDropdown catalogDropdown = header.clickOnCatalogButton();
        catalogDropdown.navigateToCoffeeSection(mainPage);
        softAssert.assertTrue(mainPage.getCoffeeComponent().isDisplayed(), "Coffee section should be displayed after clicking Coffee in dropdown.");

        header.navigateToMainPage();

        //Sets
        header.clickOnCatalogButton();
        catalogDropdown.navigateToSetsSection(mainPage);
        softAssert.assertTrue(mainPage.getSetsComponent().isDisplayed(), "Sets section should be displayed after clicking Sets in dropdown.");

        header.navigateToMainPage();

        //Komboocha
        header.clickOnCatalogButton();
        catalogDropdown.navigateToKomboochaSection(mainPage);
        softAssert.assertTrue(mainPage.getKomboochaComponent().isDisplayed(), "Komboocha section should be displayed after clicking Komboocha in dropdown.");

        header.navigateToMainPage();

        //About Us
        AboutUsComponent aboutUsSection = header.navigateToAboutUsSection(mainPage);
        softAssert.assertTrue(aboutUsSection.isDisplayed(), "About Us section should be displayed after clicking the link.");

        header.navigateToMainPage();

        //Cargo And Payment
        CargoAndPaymentComponent cargoAndPaymentSection = header.navigateToCargoAndPaymentSection(mainPage);
        softAssert.assertTrue(cargoAndPaymentSection.isDisplayed(), "Cargo and Payment section should be displayed after clicking the link.");

        header.navigateToMainPage();

        //Contacts
        boolean isFooterDisplayed = header.navigateToFooterViaContacts(mainPage).isDisplayed();
        softAssert.assertTrue(isFooterDisplayed, "Footer section should be displayed after clicking the Contacts link.");

        softAssert.assertAll();


    }
}
