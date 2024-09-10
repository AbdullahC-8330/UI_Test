package com.firsatatolyesi.tests.jsAlertTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JS_Alerts_Tasks {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com/javascript_alerts");

    }


    @Test (priority = 1)
    public void informationAlert() throws InterruptedException {

        //TC #1: Information alert practice
        //3. Click to “Click for JS Alert” button
        WebElement infoAlertBttn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        infoAlertBttn.click();

        Thread.sleep(2000);

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.

        WebElement textBttn = driver.findElement(By.cssSelector("p[id='result']"));

        Assert.assertTrue(textBttn.isDisplayed(), "Expected text is not displayed");

        String expectedText = "You successfully clicked an alerrt";
        String actualText = textBttn.getText();

        Assert.assertEquals(actualText, expectedText, "Expected text is not correct");

    }

    @Test (priority = 2)
    public void confirmationAlert1() throws InterruptedException {

        //TC #2: Confirmation alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //------->>>  setupMethod()

        //3. Click to “Click for JS Confirm” button
        WebElement confirmAlertBttn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlertBttn.click();

        Thread.sleep(2000);

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement textBttn = driver.findElement(By.cssSelector("p#result"));

        String expectedTxt = "You clicked: Ok";
        String actualText = textBttn.getText();

        Assert.assertEquals(actualText, expectedTxt, "Text message is not correct");

    }

    @Test (priority = 3)
    public void confirmationAlert2() throws InterruptedException {

        //TC #2: Confirmation alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Confirm” button
        WebElement confirmAlertBttn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlertBttn.click();

        Thread.sleep(2000);

        //4. Click to CANCEL button from the alert
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        //5. Verify “You clicked: Cancel” text is displayed.
        WebElement textBttn = driver.findElement(By.cssSelector("p#result"));

        String expectedTxt = "You clicked: Cancel";
        String actualText = textBttn.getText();

        Assert.assertEquals(actualText, expectedTxt, "Text message is not correct");

    }

    @Test (priority = 4)
    public void promtAlert() throws InterruptedException {

        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Prompt” button
        WebElement promtAlertBttn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promtAlertBttn.click();

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        Thread.sleep(2000);

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed.
        WebElement textBttn = driver.findElement(By.cssSelector("p#result"));

        String expectedText = "You entered: hello";
        String actualText = textBttn.getText();

        Assert.assertEquals(actualText, expectedText, "Text is Not Correct!");




    }

    @AfterMethod
    public void tearDown(){

        driver.close();

    }


}
