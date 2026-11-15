
package drivers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class BrowserManager {

    private static final ThreadLocal<Browser> browser =
            new ThreadLocal<>();

    public static void initialize() {

        if (browser.get() != null) {
            return;
        }

        Playwright playwright = PlayWrightManager.getPlaywright();

        if (playwright == null) {
            throw new IllegalStateException(
                    "Playwright is not initialized"
            );
        }

        boolean isCI = Boolean.parseBoolean(
                System.getProperty("ci", "false")
        );

        BrowserType.LaunchOptions options =
                new BrowserType.LaunchOptions()
                        .setHeadless(isCI);

        if (!isCI) {
            options.setArgs(List.of("--start-maximized"));
        }

        browser.set(playwright.chromium().launch(options));
    }

    public static Browser getBrowser() {
        return browser.get();
    }

    public static void close() {

        Browser instance = browser.get();

        try {
            if (instance != null) {
                instance.close();
            }
        } finally {
            browser.remove();
        }
    }
}
