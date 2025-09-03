package com.nashakava.ui.cms.page;

import com.nashakava.ui.Base;
import com.nashakava.ui.cms.component.LeftSideBar;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseCmsPage  extends Base {
    @Getter
    public LeftSideBar leftSideBar;

    @Getter
    @FindBy(xpath = "//div[@class='flex flex-col h-full']")
    private WebElement leftSideBarRoot;

    public BaseCmsPage(WebDriver driver) {
        super(driver);
        leftSideBar = new LeftSideBar(driver,leftSideBarRoot);
    }
}
