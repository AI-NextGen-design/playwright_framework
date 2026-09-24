package drivers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserManager {
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    public static void initialize(){
        Playwright playwright = PlayWrightManager.getPlaywright();
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);
        browser.set(playwright.chromium().launch(options));
    }

    public static Browser getBrowser(){
        return browser.get();
    }

    public static void close() {
        if (browser.get() != null) {
            browser.get().close();
            browser.remove();
        }
    }
}
