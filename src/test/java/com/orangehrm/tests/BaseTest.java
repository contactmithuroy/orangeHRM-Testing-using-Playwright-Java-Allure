package com.orangehrm.tests;

import com.microsoft.playwright.Page;
import com.orangehrm.pages.BrowserFactory;
import io.qameta.allure.Allure;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class BaseTest {
    protected Page page;

    @BeforeMethod
    public void setUp() {
        page = BrowserFactory.initBrowser();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            byte[] screenshot = page.screenshot();
            Allure.addAttachment("Screenshot - " + result.getName(), "image/png", 
                               new ByteArrayInputStream(screenshot), ".png");
        }
        BrowserFactory.closeBrowser();
    }
}