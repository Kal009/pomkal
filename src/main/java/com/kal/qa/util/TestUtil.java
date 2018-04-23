package com.kal.qa.util;

import com.kal.qa.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.internal.Utils;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {
    WebDriver driver;
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;


    public TestUtil() throws IOException {
    }
}
