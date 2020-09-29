package com.vytrack.tests.Fleet;

import com.vytrack.pages.Dashboard;
import com.vytrack.pages.Loginpage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleFuelLogs extends TestBase {

    @Test
    public void verifyTrackDriverCANAccessFuelLogsPage(){
        Loginpage loginpage = new Loginpage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginpage.login(username,password);

        Dashboard dashboard = new Dashboard();
        dashboard.navigateToModule("Fleet","Vehicles Fuel Logs");

        dashboard.waitUntilLoaderScreenDisappear();
        Assert.assertEquals(dashboard.pageSubTitle.getText(),"Vehicle Fuel Logs");


    }

}
