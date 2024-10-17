package com.firsatatolyesi.tests.upload_actions_jsexecuter;

import com.firsatatolyesi.pages.HoverPage;
import com.firsatatolyesi.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class HoverOver {

    //TC #3: Hover Test



    //2. Hover over to first image
    //3. Assert:
    //a. “name: user1” is displayed
    //b. “view profile” is displayed
    //4. Hover over to second image
    //5. Assert:
    //a. “name: user2” is displayed
    //b. “view profile” is displayed
    //6. Hover over to third image
    //7. Confirm:
    //a. “name: user3” is displayed
    //b. “view profile” is displayed

    @BeforeMethod
    public void setup(){
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
    }

    @Test
    public void hover_over_test(){

        HoverPage hoverPage = new HoverPage();

        Actions actions = new Actions(Driver.getDriver());

        //2. Hover over to first image
        actions.moveToElement(hoverPage.image1).perform();
        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(hoverPage.user1Txt.isDisplayed());
        //b. “view profile” is displayed
        //4. Hover over to second image
        //5. Assert:
        //a. “name: user2” is displayed
        //b. “view profile” is displayed
        //6. Hover over to third image
        //7. Confirm:
        //a. “name: user3” is displayed
        //b. “view profile” is displayed

    }


}
