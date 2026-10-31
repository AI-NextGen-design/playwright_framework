package com.avishek.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final Locator userNameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        userNameInput = page.locator("//input[@name='username']");
        passwordInput = page.locator("//input[@name = 'password']");
        loginButton = page.locator("//button[@type = 'submit']");
    }
    public void navigateToOrangeHRM(String appURL){
        page.navigate(appURL);
    }

    public void login(String username, String password){
        userNameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }
}
