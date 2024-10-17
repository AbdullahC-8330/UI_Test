package com.firsatatolyesi.tests.configurationProperty;

import com.firsatatolyesi.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ConfigTasks {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    //    public WebDriver driver;
//
//    @BeforeMethod
//    public void setupMethod(){
//
//        //We are getting the browserType dynamically from our configuration.properties file
//        String browserType = ConfigurationReader.getProperty("browser");
//        driver = WebDriverFactory.getDriver(browserType);
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//    }

    @Test
    public void google_search_test(){
        //Driver.getDriver() --> driver

        driver.get("https://www.google.com");

        WebElement clickButton = driver.findElement(By.xpath("//div[.='Alle ablehnen']"));
        clickButton.click();

        //3- Write “apple” in search box
        WebElement googleSearchBox = driver.findElement(By.xpath("//textarea[@name='q']"));

        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Google Suche";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }



}
