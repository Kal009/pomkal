package com.kal.qa.testcases;

import com.kal.qa.base.TestBase;
import com.kal.qa.pages.Homepage;
import com.kal.qa.pages.LoginPage;
import com.kal.qa.screenshots.CaptureScreenShot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {

    LoginPage lp;
    Homepage hp;

    public HomePageTest() throws IOException {
        super();
    }

    @BeforeClass
    public void setup() throws IOException {
        initialization();
        try {
            lp = new LoginPage();
            hp = new Homepage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void loginpage() {
        String tital = hp.validateHomepageTital();
        System.out.println(tital);
        Assert.assertEquals(tital, "BBC - Home");
    }

    @Test(priority = 1)
    public void homepage() {
        hp.validateHomepage();
        CaptureScreenShot.takescreeshot(driver,"Homepage_SS");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }


}
