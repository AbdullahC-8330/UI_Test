package com.firsatatolyesi.tests.upload_actions_jsexecuter;

import com.firsatatolyesi.pages.HomePage;
import com.firsatatolyesi.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scroll_Down_Up_With_Actions {

//TC #4: Scroll practice
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/

    @BeforeMethod
    public void setUp(){

        Driver.getDriver().get("https://practice.cydeo.com/");

    }

    @Test
    public void test() throws InterruptedException {

        HomePage homePage = new HomePage();

        //3- Scroll down to “Powered by CYDEO”
        //4- Scroll using Actions class “moveTo(element)” method
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homePage.poweredByCydeoLink).perform();
        Thread.sleep(2000);

        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        actions.moveToElement(homePage.homeLink).perform();

    }






}
