package com.youTube.PageObjects;
import com.youTube.BrowserUtility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideoPage extends BasePage {
    public VideoPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement ChannelIcon = driver.findElement(By.xpath("//a[contains(@class,'video-owner')]"));

    public ChannelPage OpenChannelPage()
    {
        BrowserUtility.WaitForElementClickable(driver, ChannelIcon, 3);
        ChannelIcon.click();
        return new ChannelPage(driver);
    }
}
