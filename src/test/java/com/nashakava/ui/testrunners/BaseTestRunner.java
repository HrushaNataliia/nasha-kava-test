package com.nashakava.ui.testrunners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.UUID;

import com.nashakava.utils.LocalStorageJS;
import com.nashakava.utils.TestValueProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    @Step("init ChromeDriver")
    public void initDriver() {
        ChromeOptions options = new ChromeOptions();

        String chromeOptionsArg = System.getProperty("chrome.options", "");
        if (!chromeOptionsArg.isEmpty()) {
            for (String option : chromeOptionsArg.split(",")) {
                options.addArguments(option);
            }
        }

        String userDataDir = System.getProperty("user.data.dir");
        if (userDataDir == null || userDataDir.isEmpty()) {
            userDataDir = "/tmp/chrome-" + UUID.randomUUID();
        }
        options.addArguments("--user-data-dir=" + userDataDir);

        // Мова браузера
        options.addArguments("--lang=en");

        // Headless режим для CI
        String headless = System.getProperty("headless", "true");
        if (headless.equals("true")) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
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

    @AfterClass()
    public void afterClass(ITestContext context) {
        takeScreenShot("PICTURE Test Name = " + context.getName());
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

    @Step("Clear Browser Memory Cookies and LocalStorage.")
    public void clearBrowserMemory() {
        driver.manage().deleteAllCookies();
        localStorageJS.clearLocalStorage();
        driver.navigate().refresh();
    }

    @Attachment(value = "Image name = {0}", type = "image/png")
    public byte[] takeScreenShot(String attachName) {
        byte[] result = null;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            result = Files.readAllBytes(scrFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    
}
