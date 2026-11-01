package com.avishek.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.List;

public class LandingPage {
    private final Page page;
    private final Locator upgradeButton;
    private final Locator leftNavigationMenu;

    public LandingPage(Page page){
        this.page = page;
        upgradeButton = page.locator("//button[contains(@class,'upgrade')]");
        leftNavigationMenu = page.locator("a.oxd-main-menu-item span.oxd-main-menu-item--name");
    }

    public String getUpgradeText(){
        return upgradeButton.innerText();
    }
    public List<String> getSideMenu(){
        leftNavigationMenu.first().waitFor();
        return leftNavigationMenu.allInnerTexts();
    }
}
