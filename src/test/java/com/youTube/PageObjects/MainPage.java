package com.youTube.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement SearchField = driver.findElement(By.xpath("//input[@id='search']"));
    protected WebElement SearchButton = driver.findElement(By.xpath("//button[contains(@id,'search')]"));

    public SearchPageResult SearchContent(String name)
    {
        SearchField.clear();
        SearchField.sendKeys(name);
        SearchButton.click();
        return new SearchPageResult(driver);
    }

}
