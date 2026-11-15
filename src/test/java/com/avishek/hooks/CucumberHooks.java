
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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CucumberHooks {

    private final TestContext testContext;

    public CucumberHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup() {
        PlayWrightManager.initialize();
        BrowserManager.initialize();
        BrowserContextManager.initialize();
        testContext.initializePage();
    }

    @After
    public void tearDown(Scenario scenario) {

        Page page = testContext.getPage();
        Video video = null;

        try {

            if (scenario.isFailed() && page != null) {

                String scenarioName = scenario.getName()
                        .replaceAll("[^a-zA-Z0-9.-]", "_");
                String uniqueId = java.util.UUID.randomUUID().toString();

                // 1. Create screenshot directory
                Path screenshotDir = Paths.get("target/screenshots");
                Files.createDirectories(screenshotDir);

                // 2. Capture screenshot
                byte[] screenshot = page.screenshot(
                        new Page.ScreenshotOptions().setFullPage(true)
                );

                // 3. Save actual PNG file
                Path screenshotPath =
                        screenshotDir.resolve(scenarioName + "_" + uniqueId +  ".png");

                Files.write(screenshotPath, screenshot);

                // 4. Attach screenshot to Cucumber / Allure
                scenario.attach(
                        screenshot,
                        "image/png",
                        "Failure Screenshot"
                );

                // 5. Get video reference before context closes
                video = page.video();
            }

        } catch (Exception e) {
            System.err.println("Failure evidence capture error:");
            e.printStackTrace();

        } finally {

            // 6. Close context exactly once
            try {
                BrowserContextManager.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 7. Save video after context closes
            if (scenario.isFailed() && video != null) {
                try {

                    String scenarioName = scenario.getName()
                            .replaceAll("[^a-zA-Z0-9.-]", "_");
                    String uniqueId = java.util.UUID.randomUUID().toString();

                    Path videoDir = Paths.get("target/failure-videos");
                    Files.createDirectories(videoDir);

                    Path videoPath =
                            videoDir.resolve(scenarioName +"_" + uniqueId +  ".webm");

                    video.saveAs(videoPath);

                    byte[] videoBytes = Files.readAllBytes(videoPath);

                    scenario.attach(
                            videoBytes,
                            "video/webm",
                            "Failure Execution Video"
                    );

                } catch (Exception e) {
                    System.err.println("Video attachment error:");
                    e.printStackTrace();
                }
            }

            // 8. Close browser and Playwright
            try {
                BrowserManager.close();
            } finally {
                PlayWrightManager.close();
            }
        }
    }
}