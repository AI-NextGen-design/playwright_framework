package com.avishek.stepdefinitions;

import io.cucumber.java.en.Given;

public class LoginSteps {
    @Given("the application is available")
    public void theApplicationIsAvailable() {
        System.out.println("Cucumber is working!");
    }
}
