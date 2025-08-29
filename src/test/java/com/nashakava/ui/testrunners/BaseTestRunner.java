package com.nashakava.ui.testrunners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.UUID;

import com.nashakava.utils.LocalStorageJS;
import com.nashakava.utils.TestValueProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTestRunner {

    protected static LocalStorageJS localStorageJS;
    protected static WebDriver driver;
    protected static TestValueProvider testValueProvider;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        testValueProvider = new TestValueProvider();
        initDriver();
    }

    @Step("Initialize ChromeDriver for CI")
    public void initDriver() {
        ChromeOptions options = new ChromeOptions();

      //  options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-animations");

        options.addArguments("--lang=en");
        options.addArguments("--window-size=1920,1080");

        options.addArguments("--user-data-dir=/tmp/chrome-" + UUID.randomUUID());

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(testValueProvider.getImplicitlyWait()));

        localStorageJS = new LocalStorageJS(driver);
    }

    @BeforeClass
    public void beforeClass() {
        if (driver == null) {
            initDriver();
        }
        driver.get(testValueProvider.getBaseUIUrl());

    }

    @AfterClass
    public void afterClass(ITestContext context) {
        takeScreenshot("PICTURE Test Name = " + context.getName());
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    @AfterSuite
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    @Step("Clear Browser Memory: Cookies and LocalStorage")
    public void clearBrowserMemory() {
        driver.manage().deleteAllCookies();
        localStorageJS.clearLocalStorage();
        driver.navigate().refresh();
    }

    @Attachment(value = "Screenshot: {0}", type = "image/png")
    public byte[] takeScreenshot(String attachName) {
        byte[] result = null;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            result = Files.readAllBytes(scrFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public WebElement waitUntilElementClickable(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }
}
