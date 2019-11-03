package com.youTube.PageObjects;

import com.youTube.BrowserUtility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChannelPage extends BasePage {
    public ChannelPage(WebDriver driver) {
        super(driver);
    }

    By SubscribeBtn = By.xpath("//div[@id='channel-header']//div[@id='subscribe-button']");
    By EnterBtn = By.xpath("//div[contains(@class,'modal-with-title-and-button-renderer')]");

    public void ClickSubscribe()
    {
        BrowserUtility.WaitForElementPresent(driver, SubscribeBtn,7);
        driver.findElement(SubscribeBtn).click();
        BrowserUtility.WaitForElementClickable(driver, driver.findElement(EnterBtn), 3);
    }

    public String GetEnterButtonText()
    {
        return BrowserUtility.GetElementText(driver.findElement(EnterBtn));
    }

}
