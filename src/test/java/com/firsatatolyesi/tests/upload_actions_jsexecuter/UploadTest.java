package com.firsatatolyesi.tests.upload_actions_jsexecuter;

import com.firsatatolyesi.pages.UploadPage;
import com.firsatatolyesi.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadTest {

    //TC #2 Upload Test
    //1. Go to https://practice.cydeo.com/upload
    //2. Find some small file from your computer, and get the path of it.
    //3. Upload the file.
    //4. Assert:
    //-File uploaded text is displayed on the page

    @BeforeMethod
    public void setUp(){
//1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

    }

    @Test
    public void upload_test(){
        UploadPage uploadPage = new UploadPage();

    //2. Find some small file from your computer, and get the path of it.
    //3. Upload the file.
        uploadPage.choseFileBttn.sendKeys("C:\\Users\\a\\Desktop\\upload file.docx");
        uploadPage.uploadBttn.click();

    //4. Assert:
    //-File uploaded text is displayed on the page
        Assert.assertTrue(uploadPage.fileUploadedText.isDisplayed());


    }

    @AfterMethod
    public void tearDown(){
    Driver.closeDriver();
    }


}
