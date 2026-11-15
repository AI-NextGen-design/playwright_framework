package com.avishek.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PimPage {
    private final Page page;
    public final Locator firstName;
    public final Locator middleName;
    public final Locator lastName;
    public final Locator saveButton;

    public PimPage(Page page) {
        this.page = page;
        firstName = page.locator("//input[@name = 'firstName']");
        middleName = page.locator("//input[@name = 'middleName']");
        lastName = page.locator("//input[@name = 'lastName']");
        saveButton = page.locator("//button[@type='submit']");
    }

    public Locator clickOnPIMHeader(String pimPageHeader){
        return page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Add Employee")
        );
    }

    public void enderEmployeeDetailsAndClickOnSaveButton(String firstNameValue, String middleNameValue, String lastNameValue){
       firstName.fill(firstNameValue);
       middleName.fill(middleNameValue);
       lastName.fill(lastNameValue);
    }
}