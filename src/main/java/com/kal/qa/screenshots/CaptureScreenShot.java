package com.kal.qa.screenshots;

import com.kal.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenShot extends TestBase {


    public CaptureScreenShot() throws IOException {

    }

    public static void takescreeshot(WebDriver driver, String Ssname){

        TakesScreenshot ts= (TakesScreenshot)driver;

      File source  =ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(".\\Screenshots\\"+ Ssname+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
