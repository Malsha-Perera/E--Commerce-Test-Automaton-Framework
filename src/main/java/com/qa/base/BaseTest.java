package com.qa.base;

import com.qa.utilities.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;


public class BaseTest {
    private WebDriver driver;
    String driverPath = PropertyManager.getInstance().getDriverPath();
    String url = PropertyManager.getInstance().getUrl();

    @BeforeClass
    public void launchApplication()
    {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Reporter.log("=====Browser Session Started=====", true);
        driver.get(url);
        Reporter.log("=====Application Started=====", true);
    }

    @AfterClass
    public void closeApplication()
    {
        driver.quit();
        Reporter.log("=====Browser Session End=====", true);
    }
}


