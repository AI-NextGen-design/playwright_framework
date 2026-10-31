package com.avishek.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LandingPage {
    private final Page page;
    private final Locator upgradeButton;

    public LandingPage(Page page){
        this.page = page;
        upgradeButton = page.locator("//button[contains(@class,'upgrade')]");
    }

    public String getUpgradeText(){
        return upgradeButton.innerText();
    }
}
