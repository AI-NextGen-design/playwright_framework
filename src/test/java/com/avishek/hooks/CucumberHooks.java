package com.avishek.hooks;

import Context.TestContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Video;
import drivers.BrowserContextManager;
import drivers.BrowserManager;
import drivers.PlayWrightManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Collections.replaceAll;

public class CucumberHooks {
    private final TestContext testContext;

    public CucumberHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup(){
        PlayWrightManager.initialize();
        BrowserManager.initialize();
        BrowserContextManager.initialize();
        testContext.initializePage();

    }

    @After
    public void tearDown(Scenario scenario){
        Page page = testContext.getPage();
        try{
            if(scenario.isFailed() && page != null){
                String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_");
                // Create screenshot directory
                Path screenshotDir = Paths.get("target/screenshots");
                Files.createDirectories(screenshotDir);

                // Take ScreenShot
                byte[] screenshot = page.screenshot(
                        new Page.ScreenshotOptions().setFullPage(true)
                );

                Path screenShotPath = screenshotDir.resolve(scenarioName+".png");
                Files.write(screenShotPath, screenshot);

                // Attach screenshot to cucumber report
                scenario.attach(screenshot,
                        "image.png",
                        "Failure Screenshot");

                // Get video reference before closing context
                Video video = page.video();

                // Close context to finalize video
                BrowserContextManager.close();

                if (video != null) {

                    Path videoDir = Paths.get("target/failure-videos");
                    Files.createDirectories(videoDir);

                    Path videoPath =
                            videoDir.resolve(scenarioName + ".webm");

                    video.saveAs(videoPath);

                    byte[] videoBytes = Files.readAllBytes(videoPath);

                    scenario.attach(
                            videoBytes,
                            "video/webm",
                            "Failure Execution Video"
                    );
                }

            } else {
                BrowserContextManager.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            BrowserContextManager.close();
            BrowserManager.close();
            PlayWrightManager.close();
        }

    }
}
