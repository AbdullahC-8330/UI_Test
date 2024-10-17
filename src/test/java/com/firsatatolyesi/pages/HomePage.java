package com.firsatatolyesi.pages;

import com.firsatatolyesi.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (xpath = "//a[.='Home']")
    public WebElement homeLink;

    @FindBy (xpath = "//div[@style='text-align: center;']")
    public WebElement poweredByCydeoLink;



}
