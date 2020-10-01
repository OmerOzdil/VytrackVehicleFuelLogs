package com.vytrack.tests;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    @BeforeMethod
    public void setUp(){
        driver= Driver.get();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
        //action= new Actions(driver);
        //wait = new WebDriverWait(driver,5);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
    Thread.sleep(1000);
    Driver.closeDriver();
    }
}
