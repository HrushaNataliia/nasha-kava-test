package com.nashakava.ui;

import com.nashakava.ui.cms.page.LogInPage;
import com.nashakava.ui.cms.page.OrdersPage;
import com.nashakava.ui.testrunners.BaseTestRunner;
import org.testng.annotations.Test;



public class BaseTest extends BaseTestRunner {

    @Test
    public void crmFirstTest() {
        LogInPage loginPage = new LogInPage(driver);

        OrdersPage ordersPage = loginPage.clickOnEmailPasswordButton()
                .enterEmail(testValueProvider.getAdminEmail())
                .clickOnNextButton()
                .enterPassword(testValueProvider.getAdminPassword())
                .clickOnLoginButton()
                .getLeftSideBar()
                .clickOnOrdersButton();


    }
}








