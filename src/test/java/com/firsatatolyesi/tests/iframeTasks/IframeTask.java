package com.firsatatolyesi.tests.iframeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTask {

    WebDriver driver;
    //TC #4: Iframe practice
    //1. Create a new class called: T4_Iframes
    //2. Create new test and make set ups
    //3. Go to: https://practice.cydeo.com/iframe
    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/iframe");

    }

    @Test
    public void iframeTest(){

        //4. Assert: “Your content goes here.” Text is displayed.
        WebElement iframe = driver.findElement(By.tagName("iframe"));

        //driver.switchTo().frame(iframe);
        //driver.switchTo().frame("mce_0_ifr");  //  id value of element with iframe tag
        driver.switchTo().frame(0);

        WebElement iframeTextElmnt = driver.findElement(By.xpath("//p"));
        String expectedText = "Your content goes here.";
        String actualText = iframeTextElmnt.getText();

        Assert.assertEquals(actualText, expectedText);

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();

        WebElement parentFrameText = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(parentFrameText.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
