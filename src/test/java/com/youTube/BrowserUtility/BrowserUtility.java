package com.youTube.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtility {

    private static WebDriverWait wait;

    //private static String _location = Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location);

    public enum BrowserType { Chrome, FireFox, IE, Edge, Safari };

    public static void WaitForElementVisible(WebDriver webDriver, WebElement element, int timeForElementDisplayed)
    {
        wait = new WebDriverWait(webDriver, timeForElementDisplayed);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void WaitForElementClickable(WebDriver webDriver, WebElement element, int timeForElementDisplayed)
    {
        wait = new WebDriverWait(webDriver, timeForElementDisplayed);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void WaitForElementPresent(WebDriver webDriver, By by, int timeOut)
    {
        wait = new WebDriverWait(webDriver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static String GetElementText(WebElement element)
    {
        return element.getText();
    }

    public static WebDriver GetDriver(BrowserType type)
    {
        switch (type)
        {
            case Chrome: {
                System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\test\\java\\chromedriver.exe");
                return new ChromeDriver();
            }
            case FireFox: return new FirefoxDriver();
            case Safari: return  new SafariDriver();
            case IE: return  new InternetExplorerDriver();
            case Edge: return new EdgeDriver();
            default: return  new ChromeDriver();
        }
    }

    public static void LoadPage(WebDriver driver, String url)
    {
        driver.manage().window().maximize();
        driver.get(url);
    }

}

