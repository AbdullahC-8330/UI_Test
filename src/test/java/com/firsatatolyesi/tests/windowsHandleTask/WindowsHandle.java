package com.firsatatolyesi.tests.windowsHandleTask;

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

public class WindowsHandle {

    WebDriver driver;

    //TC #5: Window Handle practice
    //1. Create a new class called: T5_WindowsPractice


    @BeforeMethod
    public void setUp(){

        //2. Create new test and make set ups
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");

    }

    @Test
    public void test(){

        //4. Assert: Title is “Windows”
        String firstWindowHandle = driver.getWindowHandle();
        System.out.println("firstWindowHandle = " + firstWindowHandle);

        String expectedFirstTitle = "Windows";
        String actualFirstTitle = driver.getTitle();

        Assert.assertEquals(actualFirstTitle, expectedFirstTitle, "Page title verification was failed!");

        //5. Click to: “Click Here” link
        WebElement clickHereBttn = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        clickHereBttn.click();

        //6. Switch to new Window.
        for (String eachWindowHandle : driver.getWindowHandles()) {

            driver.switchTo().window(eachWindowHandle);
            System.out.println(driver.getWindowHandle());

        }

        //7. Assert: Title is “New Window”
        String expectedSecondTitle = "New Window";
        String actualSecondTitle = driver.getTitle();

        Assert.assertEquals(actualSecondTitle, expectedSecondTitle);


    }

    @AfterMethod
    public void tearDown(){

        driver.quit();

    }





}
