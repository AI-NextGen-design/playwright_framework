package com.avishek.stepdefinitions;

import Context.TestContext;
import io.cucumber.java.en.Given;

public class LoginSteps {
    private final TestContext testContext;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
    }
    @Given("the application is available")
    public void theApplicationIsAvailable() {
        System.out.println("Cucumber is working!");
    }
}
