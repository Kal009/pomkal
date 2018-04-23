package com.kal.qa.base;

import com.kal.qa.util.TestUtil;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\Trupesh\\IdeaProjects\\pomkal\\src\\main\\java\\com\\kal\\qa\\config\\config.properties");
        prop.load(ip);

    }


    public static void initialization() throws MalformedURLException {

       /* //selenium grid code
        DesiredCapabilities caps =  DesiredCapabilities.firefox();
        caps.setPlatform(Platform.WIN10);
       // caps.setCapability("version", "15.15063");

        URL urls = new URL("http://192.168.0.20:4444/wd/hub");
        driver = new RemoteWebDriver(urls,caps);*/


       String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "C:\\Cucumbe jars\\MicrosoftWebDriver.exe");
            driver = new InternetExplorerDriver();
        }


        //driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }

}
