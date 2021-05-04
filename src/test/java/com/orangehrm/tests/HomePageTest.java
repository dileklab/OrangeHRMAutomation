package com.orangehrm.tests;

import com.orangehrm.base.BasePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BasePage {

    LoginPage loginPage;
    HomePage homePage;

    HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initializeDriver();
        loginPage = new LoginPage();
        homePage = loginPage.validateLogin(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        String title = homePage.validateHomePageTitle();
        Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
        Log.info("Home Page Title verified");
    }

    @Test(priority = 2)
    public void verifyHomePageQuickLaunchItems() {
        Assert.assertEquals(homePage.validateQuickLaunchItems(), Constants.HOME_PAGE_ITEMS);
        Log.info("Home page quick launch items verified");
    }

    @Test(priority = 3)
    public void verifyAuthentication() {
        String url = homePage.getHomePageUrl();
        Assert.assertEquals(url, Constants.HOME_PAGE_URL);
        Log.info("Home page url is verified");
    }
}
