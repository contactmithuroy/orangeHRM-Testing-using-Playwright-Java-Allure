package com.orangehrm.pages;

import com.microsoft.playwright.*;
import com.orangehrm.utils.ConfigReader;

public class BrowserFactory {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    public static Page initBrowser() {
        closeBrowser();
        String browserName = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
        String baseUrl = ConfigReader.get("baseUrl");

        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "edge":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless).setChannel("msedge"));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless).setChannel("chrome"));
                break;
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
        }
        page = browser.newContext().newPage();
        page.setViewportSize(1366, 768); 
        page.navigate(baseUrl);
        return page;
    }

    public static void closeBrowser() {
        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        page = null;
        browser = null;
        playwright = null;
    }

    public static Page getPage() {
        return page;
    }
}