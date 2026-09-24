package drivers;

import com.microsoft.playwright.Playwright;

public class PlayWrightManager {
    public static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();

    public static void initialize(){
        playwright.set(Playwright.create());
    }

    public static Playwright getPlaywright(){
        return playwright.get();
    }

    public static void close(){
        if(playwright.get() !=null){
            playwright.get().close();
            playwright.remove();
        }
    }
}
