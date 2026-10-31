package drivers;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;

// This creates isolated sessions
public class BrowserContextManager {
    private static final ThreadLocal<BrowserContext> context =
            new ThreadLocal<>();

    public static void initialize() {

        BrowserContext browserContext =
                BrowserManager.getBrowser().newContext();

        context.set(browserContext);
    }

    public static BrowserContext getContext() {
        return context.get();
    }

    public static void close() {
        if (context.get() != null) {
            context.get().close();
            context.remove();
        }
    }

}
