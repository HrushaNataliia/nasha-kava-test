package com.nashakava.ui;


import com.nashakava.ui.component.HeaderComponent;
import com.nashakava.ui.page.MainPage;
import com.nashakava.ui.testrunners.BaseTestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class BaseTest extends BaseTestRunner {

    @Test
    public void firstTest() {
        SoftAssert softAssert = new SoftAssert();

        MainPage menuPage = new MainPage(driver);
        HeaderComponent header = menuPage.getHeader();

        int initialCount = header.getTotalNumberFromHeaderCartCounter();
        System.out.println(initialCount);
        softAssert.assertEquals(initialCount, 0, "Initial counter should be 0");


    }
}








