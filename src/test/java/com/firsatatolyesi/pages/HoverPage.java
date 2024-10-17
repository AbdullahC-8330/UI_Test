package com.firsatatolyesi.pages;

import com.firsatatolyesi.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoverPage {

    public HoverPage(){

    PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy ( xpath = "(//img)[1]")
    public WebElement image1;

    @FindBy (xpath = "(//img)[2]")
    public WebElement image2;

    @FindBy (xpath = "(//img)[3]")
    public WebElement image3;

    @FindBy (xpath = "//h5[. = 'name: user1']")
    public WebElement user1Txt;

    @FindBy ( xpath ="//h5[. = 'name: user2']")
    public WebElement user2Txt;

    @FindBy ( xpath ="//h5[. = 'name: user3']")
    public WebElement user3Txt;



}
