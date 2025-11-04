package com.orangehrm.tests;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("OrangeHRM Tests")
@Feature("Login Functionality")
public class LoginTest extends BaseTest {

    private String username;
    private String password;
    private LoginPage loginPage;

    @BeforeClass
    public void loadEnvironment() {
        username = ConfigReader.get("username");
        password = ConfigReader.get("password");
        loginPage = new LoginPage(page);
    }

    @Test(priority = 1, description = "Successful login with valid credentials")
    @Description("Verify successful login redirects to dashboard")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login with valid credentials")
    public void testValidLogin() {
        loginPage.login(username, password);
        page.waitForTimeout(5000);
        Assert.assertTrue(loginPage.isDashboardVisible());
    }
}