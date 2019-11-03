package com.youTube.PageObjects;

import com.youTube.BrowserUtility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPageResult extends BasePage {

    public SearchPageResult(WebDriver driver) {
        super(driver);
    }

    protected String SearchResultXpath = "(//div[@class='style-scope ytd-video-renderer'])[%d]";

    public VideoPage SelectVideoByNumber(int number) {

        BrowserUtility.WaitForElementPresent(driver, By.xpath(String.format(SearchResultXpath, (number - 1)*6 + 1)),5);
        driver.findElement(By.xpath(String.format(SearchResultXpath, (number - 1)*6 + 1))).click();
        return new VideoPage(driver);
    }
}
