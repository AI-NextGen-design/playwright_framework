package com.avishek.stepdefinitions;

import Context.TestContext;
import com.avishek.pages.LandingPage;
import com.avishek.pages.LoginPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LandingPageSteps {
    TestContext testContext;
    LoginPage loginPage;
    LandingPage landingPage;

    public LandingPageSteps(TestContext testContext){
        this.testContext = testContext;
        this.loginPage = new LoginPage(testContext.getPage());
        this.landingPage = new LandingPage(testContext.getPage());
    }

    @Then("navigate the side menu options")
    public void validateTheSideMenu(List<String> expectedSideMenu){
        Set<String> actualSideMenu = new HashSet<>(landingPage.getSideMenu());
        Assert.assertEquals(actualSideMenu, new HashSet<>(expectedSideMenu));
    }
}
