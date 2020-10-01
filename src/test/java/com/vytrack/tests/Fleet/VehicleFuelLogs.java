package com.vytrack.tests.Fleet;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.Dashboard;
import com.vytrack.pages.Loginpage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleFuelLogs extends TestBase {


    @Test
    public void verifyTrackDriverCANAccessFuelLogsPage(){
        Loginpage loginpage = new Loginpage();
        Dashboard dashboard = new Dashboard();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginpage.loginAsDriver(username,password);


        dashboard.navigateToModule("Fleet","Vehicles Fuel Logs");

        dashboard.waitUntilLoaderScreenDisappear();
        Assert.assertEquals(dashboard.pageSubTitle.getText(),"Vehicle Fuel Logs");

    }

    @Test
    public void SalesManagerCANNOTAccessFuelLogsPage(){

        Loginpage loginpage = new Loginpage();
        Dashboard dashboard = new Dashboard();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        loginpage.loginAsSalesManager(username,password);

        dashboard.navigateToModule("Fleet","Vehicles Fuel Logs");

        WebElement message = driver.findElement(By.xpath("(//div[@class='message'])[2]"));

        String expectedMessage="You do not have permission to perform this action.";

        //message is appeared
        dashboard.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(message.getText(),expectedMessage);
        System.out.println(message.getText());

    }
    @Test
    public void StoreManagerCANNOTAccessFuelLogsPage(){

        Loginpage loginpage = new Loginpage();
        Dashboard dashboard = new Dashboard();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginpage.loginAsSalesManager(username,password);

        dashboard.navigateToModule("Fleet","Vehicles Fuel Logs");

        WebElement message = driver.findElement(By.xpath("(//div[@class='message'])[2]"));

        String expectedMessage="You do not have permission to perform this action.";
        //message is appeared
        dashboard.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(message.getText(),expectedMessage);
        System.out.println(message.getText());

    }


}
