package com.youTube.Tests.UI;

import com.youTube.BrowserUtility.BrowserUtility;
import com.youTube.Settings.Settings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestClass {

    WebDriver driver;

    @BeforeMethod
    public void SetUp() {

        driver = BrowserUtility.GetDriver(BrowserUtility.BrowserType.Chrome);
        BrowserUtility.LoadPage(driver, Settings.Url);
    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
