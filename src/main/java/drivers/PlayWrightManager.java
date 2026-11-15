package drivers;

import com.microsoft.playwright.Playwright;

public class PlayWrightManager {
    public static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();

    public static void initialize(){
        if(playwright.get() == null) {
            playwright.set(Playwright.create());
        }
    }

    public static Playwright getPlaywright(){
        return playwright.get();
    }

    public static void close(){
        Playwright instance = playwright.get();
        try{
            if(instance !=null){
                instance.close();
            }
        }
        finally {
            playwright.remove();
        }
    }
}
