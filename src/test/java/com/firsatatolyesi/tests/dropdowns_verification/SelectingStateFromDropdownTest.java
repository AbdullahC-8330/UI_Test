package com.firsatatolyesi.tests.dropdowns_verification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SelectingStateFromDropdownTest {

//TC #5: Selecting state from State dropdown and verifying result

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    @Test
    public void test1(){

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        ////3. Select Illinois
        stateDropDown.selectByVisibleText("Illinois");

        ////4. Select Virginia
        stateDropDown.selectByValue("VA");

        ////5. Select California
        stateDropDown.selectByIndex(5);

        ////6. Verify final selected option is California.
        String finalSelectedOption =  stateDropDown.getFirstSelectedOption().getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(finalSelectedOption, "California");

        softAssert.assertAll();


        ////Use all Select options. (visible text, value, index)

    }

    @Test
    public void test2(){

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        ////3. Select Illinois
        stateDropDown.selectByVisibleText("Illinois");

        ////4. Select Virginia
        stateDropDown.selectByValue("VA");

        ////5. Select California
        stateDropDown.selectByIndex(5);

        ////6. Verify final selected option is California.
        String finalSelectedOption =  stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(finalSelectedOption, "California");
        Assert.assertTrue(finalSelectedOption.equals("California"));


        ////Use all Select options. (visible text, value, index)

    }
    @AfterMethod
    public void tearDown(){

        driver.close();
    }


}
