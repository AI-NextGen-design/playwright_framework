package com.avishek.hooks;

import Context.TestContext;
import drivers.BrowserContextManager;
import drivers.BrowserManager;
import drivers.PlayWrightManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
    private final TestContext testContext;

    public CucumberHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup(){
        PlayWrightManager.initialize();
        BrowserManager.getBrowser();
        BrowserContextManager.initialize();
        testContext.initializePage();

    }

    @After
    public void tearDown(){
        BrowserContextManager.close();
        BrowserManager.close();
        PlayWrightManager.close();

    }
}
