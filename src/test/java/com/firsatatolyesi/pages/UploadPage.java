package com.firsatatolyesi.pages;

import com.firsatatolyesi.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage {

    public UploadPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (id = "file-upload")
    public WebElement choseFileBttn;

    @FindBy (id ="file-submit")
    public WebElement uploadBttn;

    @FindBy (xpath = "//h3[.='File Uploaded!']")
    public WebElement fileUploadedText;


}
