package com.avishek.stepdefinitions;

import Context.TestContext;
import com.avishek.config.ConfigManager;
import com.avishek.pages.LandingPage;
import com.avishek.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    private final TestContext testContext;
    private final LoginPage loginPage;
    private final LandingPage landingPage;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        this.loginPage = new LoginPage(testContext.getPage());
        this.landingPage = new LandingPage(testContext.getPage());
    }

    @Given("Navigate to the OrangeHRM login page")
    public void navigateToOrangeHRM(){
        String appURL = ConfigManager.getBaseUrl();
        loginPage.navigateToOrangeHRM(appURL);
    }

    @When("Enter login credentials and click on login button")
    public void loginToOrangeHRM(){
        loginPage.login(ConfigManager.getUsername(), ConfigManager.getPassword());
    }

    @Then("User should see the upgrade button and get {string} text")
    public void validateTheUpgradeButton(String expectedText){
        String actualText = landingPage.getUpgradeText();
        Assert.assertEquals(actualText, expectedText);
    }
}
