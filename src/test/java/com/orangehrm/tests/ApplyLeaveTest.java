package com.orangehrm.tests;

import com.orangehrm.pages.ApplyLeavePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("OrangeHRM Tests")
@Feature("Leave Management")
public class ApplyLeaveTest extends BaseTest {

    private String username;
    private String password;
    private String comment;

    @Test(priority = 1, description = "Verify user can apply for leave with first available leave type")
    @Description("Test applying leave by selecting first available leave type from dropdown")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Apply leave functionality")
    public void testApplyLeaveWithFirstAvailableType() {
        LoginPage loginPage = new LoginPage(page);
        ApplyLeavePage applyLeavePage = new ApplyLeavePage(page);
        
        username = ConfigReader.get("username");
        password = ConfigReader.get("password");
        comment = ConfigReader.get("leave.comment");
        
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isDashboardVisible(), "Login should be successful");
        applyLeavePage.applyLeave(comment);
        Assert.assertTrue(applyLeavePage.isSuccessMessageVisible(), "Leave application should be successful");
    }

    @Test(priority = 2, description = "Verify user cannot apply leave without selecting a Leave Type")
    @Description("Test that leave application fails when leave type is not selected")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Leave validation functionality")
    public void testCannotApplyLeaveWithoutLeaveType() {
        LoginPage loginPage = new LoginPage(page);
        ApplyLeavePage applyLeavePage = new ApplyLeavePage(page);
        
        username = ConfigReader.get("username");
        password = ConfigReader.get("password");
        comment = ConfigReader.get("leave.comment");
        
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isDashboardVisible(), "Login should be successful");
        applyLeavePage.applyLeaveWithoutLeaveType(comment);
        Assert.assertTrue(applyLeavePage.isErrorMessageVisible(), "Error message should be visible for missing leave type");
    }

    @Test(priority = 3, description = "Verify user cannot apply leave when From Date is after To Date")
    @Description("Test that leave application fails when From Date is later than To Date")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Date validation functionality")
    public void testCannotApplyLeaveWithInvalidDateRange() {
        LoginPage loginPage = new LoginPage(page);
        ApplyLeavePage applyLeavePage = new ApplyLeavePage(page);
        
        username = ConfigReader.get("username");
        password = ConfigReader.get("password");
        comment = ConfigReader.get("leave.comment");
        
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isDashboardVisible(), "Login should be successful");
        applyLeavePage.applyLeaveWithInvalidDateRange(comment);
        Assert.assertTrue(applyLeavePage.isErrorMessageVisible(), "Error message should be visible for invalid date range");
    }
}