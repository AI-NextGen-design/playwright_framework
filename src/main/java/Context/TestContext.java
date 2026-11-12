package Context;

import com.microsoft.playwright.Page;
import drivers.BrowserContextManager;

public class TestContext {
    private Page page;

    public void initializePage() {
        page = BrowserContextManager
                .getContext()
                .newPage();
        page.setDefaultTimeout(30000);
        page.setDefaultNavigationTimeout(60000);
    }

    public Page getPage() {
        return page;
    }
}
