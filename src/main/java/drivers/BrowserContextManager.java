package drivers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import java.nio.file.Paths;

// This creates isolated sessions
public class BrowserContextManager {
    private static final ThreadLocal<BrowserContext> context =
            new ThreadLocal<>();

    public static void initialize() {
        if (context.get() != null) {
            return;
        }
        Browser browser = BrowserManager.getBrowser();
        if (browser == null) {
            throw new IllegalStateException(
                    "Browser is not initialized"
            );
        }
        Browser.NewContextOptions options = new Browser.NewContextOptions().setViewportSize(1920, 1080)
                .setRecordVideoDir(Paths.get("target/videos"))
                .setRecordVideoSize(1280, 720);
        BrowserContext browserContext =
                BrowserManager.getBrowser().newContext(options);
        context.set(browserContext);
    }

    public static BrowserContext getContext() {
        return context.get();
    }

    public static void close() {
        BrowserContext instance = context.get();
        try {
            if (instance != null) {
                instance.close();
            }
        } finally {
            context.remove();
        }
    }

}
