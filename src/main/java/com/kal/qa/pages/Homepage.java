package com.kal.qa.pages;

import com.kal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Homepage extends TestBase {

    public Homepage() throws IOException {
        PageFactory.initElements(driver,this);
    }


    //@FindBy(how = How.LINK_TEXT, using = "Homepage")
    @FindBy(linkText = "Homepage")
    WebElement homepagelink;

    @FindBy(how = How.ID,using = "idcta-link")
    WebElement loginpagelink;

    //Action
    public String validateHomepageTital(){
        return driver.getTitle();
    }
    public void validateHomepage(){
        homepagelink.click();

    }



}
