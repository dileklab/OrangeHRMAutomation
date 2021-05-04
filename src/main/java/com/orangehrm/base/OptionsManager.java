package com.orangehrm.base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.orangehrm.base.BasePage.properties;

public class OptionsManager {

    static ChromeOptions co;
    static FirefoxOptions fo;

    public static ChromeOptions getChromeOptions() {
        co = new ChromeOptions();
        if (properties.getProperty("incognito").equals("yes")) co.addArguments("--incognito");
        if (properties.getProperty("headless").equals("yes")) co.addArguments("--headless");
        return co;
    }

    public static FirefoxOptions getFirefoxOptions() {
        fo = new FirefoxOptions();
        if (properties.getProperty("incognito").equals("yes")) co.addArguments("-private");
        if (properties.getProperty("headless").equals("yes")) fo.addArguments("--headless");
        return fo;
    }
}
