package com.youTube.Tests.UI;

import com.youTube.PageObjects.ChannelPage;
import com.youTube.PageObjects.MainPage;
import com.youTube.PageObjects.SearchPageResult;
import com.youTube.PageObjects.VideoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class NewTestClass extends BaseTestClass {

    @Test
    public void CheckPageTitle(){
        String expectedTitle = "YouTube";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title doesn't match");
    }

    @Test
    public void CheckEnterButtonText() {

        String expectedButtonText = "ВОЙТИ";
        Random random = new Random();
        MainPage mainPage = new MainPage(driver);
        SearchPageResult searchPageResult = mainPage.SearchContent(Integer.toString(random.nextInt(1000)));
        VideoPage videoPage = searchPageResult.SelectVideoByNumber(4);
        ChannelPage channelPage = videoPage.OpenChannelPage();
        channelPage.ClickSubscribe();
        Assert.assertEquals(channelPage.GetEnterButtonText(), expectedButtonText, "Text in button doesn't match");
    }
}
