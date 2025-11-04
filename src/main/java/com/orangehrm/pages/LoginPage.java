package com.orangehrm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator dashboardHeader;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("input[name='username']");
        this.passwordInput = page.locator("input[name='password']");
        this.loginButton = page.locator("button[type='submit']");
        this.dashboardHeader = page.locator(".oxd-topbar-header-breadcrumb");
    }

    public void login(String username, String password) {
        usernameInput.waitFor();
        usernameInput.fill(username);
        
        passwordInput.waitFor();
        passwordInput.fill(password);
        
        loginButton.waitFor();
        loginButton.click();
        
        dashboardHeader.waitFor();
    }

    public boolean isDashboardVisible() {
        return dashboardHeader.isVisible();
    }
}