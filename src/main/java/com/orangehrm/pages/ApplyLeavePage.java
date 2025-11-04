package com.orangehrm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.time.LocalDate;

public class ApplyLeavePage {

    private final Page page;
    private final Locator leaveMenu;
    private final Locator applyLeaveSubMenu;
    private final Locator leaveTypeDropdown;
    private final Locator fromDateInput;
    private final Locator toDateInput;
    private final Locator commentTextarea;
    private final Locator applyButton;
    private final Locator successMessage;
    private final Locator errorMessage;

    public ApplyLeavePage(Page page) {
        this.page = page;
        this.leaveMenu = page.locator("//span[normalize-space()='Leave']");
        this.applyLeaveSubMenu = page.locator("//a[normalize-space()='Apply']");
        this.leaveTypeDropdown = page.locator("//label[contains(text(),'Leave Type')]/following::div[contains(@class,'oxd-select-wrapper')][1]");
        this.fromDateInput = page.locator("//label[contains(text(),'From Date')]/following::input[contains(@class,'oxd-input')][1]");
        this.toDateInput = page.locator("//label[contains(text(),'To Date')]/following::input[contains(@class,'oxd-input')][1]");
        this.commentTextarea = page.locator("//textarea");
        this.applyButton = page.locator("//button[normalize-space()='Apply']");
        this.successMessage = page.locator("//p[contains(.,'Successfully') or contains(.,'Saved')]");
        this.errorMessage = page.locator("//span[contains(@class,'error')]");
    }

    public void applyLeave(String comment) {
        String fromDate = LocalDate.now().plusDays(2).toString();
        String toDate = LocalDate.now().plusDays(3).toString();
        
        leaveMenu.waitFor();
        leaveMenu.click();
        applyLeaveSubMenu.waitFor();
        applyLeaveSubMenu.click();
        selectFirstAvailableLeaveType();
        
        fromDateInput.waitFor();
        fromDateInput.click();
        page.keyboard().press("Control+A");
        fromDateInput.fill(fromDate);
        
        toDateInput.waitFor();
        toDateInput.click();
        page.keyboard().press("Control+A");
        toDateInput.fill(toDate);
        
        commentTextarea.waitFor();
        commentTextarea.fill(comment);
        applyButton.waitFor();
        applyButton.click();
    }

    public void applyLeaveWithoutLeaveType(String comment) {
        String fromDate = LocalDate.now().plusDays(2).toString();
        String toDate = LocalDate.now().plusDays(3).toString();
        
        leaveMenu.waitFor();
        leaveMenu.click();
        applyLeaveSubMenu.waitFor();
        applyLeaveSubMenu.click();
        
        fromDateInput.waitFor();
        fromDateInput.click();
        page.keyboard().press("Control+A");
        fromDateInput.fill(fromDate);
        
        toDateInput.waitFor();
        toDateInput.click();
        page.keyboard().press("Control+A");
        toDateInput.fill(toDate);
        
        commentTextarea.waitFor();
        commentTextarea.fill(comment);
        applyButton.waitFor();
        applyButton.click();
    }

    public void applyLeaveWithInvalidDateRange(String comment) {
        String fromDate = LocalDate.now().plusDays(5).toString();
        String toDate = LocalDate.now().plusDays(3).toString();
        
        leaveMenu.waitFor();
        leaveMenu.click();
        applyLeaveSubMenu.waitFor();
        applyLeaveSubMenu.click();
        selectFirstAvailableLeaveType();
        
        fromDateInput.waitFor();
        fromDateInput.click();
        page.keyboard().press("Control+A");
        fromDateInput.fill(fromDate);
        
        toDateInput.waitFor();
        toDateInput.click();
        page.keyboard().press("Control+A");
        toDateInput.fill(toDate);
        
        commentTextarea.waitFor();
        commentTextarea.fill(comment);
        applyButton.waitFor();
        applyButton.click();
    }

    public boolean isErrorMessageVisible() {
        page.waitForTimeout(3000);
        return errorMessage.isVisible();
    }

    public boolean isSuccessMessageVisible() {
        page.waitForTimeout(5000);
        return successMessage.isVisible();
    }

    private void selectFirstAvailableLeaveType() {
        leaveTypeDropdown.waitFor();
        leaveTypeDropdown.click();
        page.waitForTimeout(2000);
        page.locator("//div[@role='option']//span").first().click();
    }
}