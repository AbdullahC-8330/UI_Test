package com.firsatatolyesi.tests.registration;

import com.firsatatolyesi.pages.RegistrationPage;
import com.firsatatolyesi.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Successfull_Registration {

    //TC#1: Registration form confirmation
    //Note: Use JavaFaker OR read from configuration.properties file when possible.

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @BeforeMethod
    public void setUpMethod(){

        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form

        Driver.getDriver().get("https://practice.cydeo.com/registration_form");
    }

    @Test
    public void registration_test(){

        //3. Enter first name
        String firstname = faker.name().firstName();
        registrationPage.firstNameBox.sendKeys(firstname);

        //4. Enter last name
        String lastName = faker.name().lastName();
        registrationPage.lastNameBox.sendKeys(lastName);

        //5. Enter username
        String userName = "" + firstname.charAt(0) + lastName.charAt(0) + faker.numerify("####");
        registrationPage.userNameBox.sendKeys(userName);

        //6. Enter email address
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());

        //7. Enter password
        String passWord = faker.internet().password(8, 15, true, true, true);
        System.out.println("passWord = " + passWord);

        registrationPage.passwordBox.sendKeys(passWord);

        //8. Enter phone number
        registrationPage.phoneNumberBox.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        for (WebElement genderRadioButton : registrationPage.genderRadioButtons) {
            int i=0;
            genderRadioButton.click();
            if (i == faker.number().numberBetween(1, 4)){
                break;
            };
        }

        //10. Enter date of birth
        String birthday = faker.number().numberBetween(1,12) + "/" + faker.number().numberBetween(1,30) + "/" + faker.number().numberBetween(1900, 2005);
        System.out.println("birthday = " + birthday);
        registrationPage.birtdayBox.sendKeys(birthday);

        //11. Select Department/Office
        Select select = new Select(registrationPage.departmentsDropDown);
        select.selectByIndex(faker.number().numberBetween(2,10));

        //12. Select Job Title
        Select select1 = new Select(registrationPage.jobTitleDropDown);
        select1.selectByIndex(faker.number().numberBetween(2,9));

        //13. Select programming language from checkboxes
        for (WebElement programmingLanguagesCheckbox : registrationPage.programmingLanguagesCheckboxes) {
            int i = 1;

            if (i == faker.number().numberBetween(1,3)){
                programmingLanguagesCheckbox.click();
                break;
            }
        }

        //14. Click to sign up button
        registrationPage.signUpButton.click();

        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed.

        Assert.assertTrue(registrationPage.successfullMessage.isDisplayed());







    }


}
