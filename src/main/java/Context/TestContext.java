package Context;

import com.microsoft.playwright.Page;
import drivers.BrowserContextManager;

public class TestContext {
    private Page page;

    public void initializePage() {
        page = BrowserContextManager
                .getContext()
                .newPage();
    }

    public Page getPage() {
        return page;
    }
}
