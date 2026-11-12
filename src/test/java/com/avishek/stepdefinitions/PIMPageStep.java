package com.avishek.stepdefinitions;

import Context.TestContext;
import com.avishek.pages.PimPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.ITestContext;

public class PIMPageStep {
    TestContext testContext;
    PimPage pimPage;

    public PIMPageStep(TestContext testContext){
        this.testContext = testContext;
        this.pimPage = new PimPage(testContext.getPage());
    }

    @Then("Click On Add Employee {string}")
    public void clickOnAddEmployee(String headerMenu) {
        pimPage.clickOnPIMHeader(headerMenu).click();
    }

    @And("Enter employee details and click on save button {string} {string} {string}")
    public void enterEmployeeDetailsAndClickOnSaveButton(String firstName, String middleName, String lastName) throws InterruptedException {
        pimPage.firstName.fill(firstName);
        pimPage.middleName.fill(middleName);
        pimPage.lastName.fill(lastName);
        pimPage.saveButton.click();
        Thread.sleep(10000);
    }
}
