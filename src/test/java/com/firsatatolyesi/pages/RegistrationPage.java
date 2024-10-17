package com.firsatatolyesi.pages;

import com.firsatatolyesi.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegistrationPage {


    public RegistrationPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (name = "firstname")
    public WebElement firstNameBox;

    @FindBy (name = "lastname")
    public WebElement lastNameBox;

    @FindBy (name = "username")
    public WebElement userNameBox;

    @FindBy (css = "input[placeholder='email@email.com']")
    public WebElement emailBox;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy (xpath = "//input[@name='phone']")
    public WebElement phoneNumberBox;

    @FindBy (css = "input[type = 'radio']")
    public List<WebElement> genderRadioButtons;

    @FindBy (css = "input[name = 'birthday']")
    public WebElement birtdayBox;

    @FindBy (css = "select[name = 'department']")
    public WebElement departmentsDropDown;

    @FindBy (css = "select[name = 'job_title']")
    public WebElement jobTitleDropDown;

    @FindBy (css = "input[type = 'checkbox']")
    public List<WebElement> programmingLanguagesCheckboxes;

    @FindBy (id = "wooden_spoon")
    public WebElement signUpButton;

    @FindBy (xpath = "//p[.=\"You've successfully completed registration!\"]")
    public WebElement successfullMessage;







}
