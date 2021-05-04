package com.orangehrm.tests;

import com.orangehrm.base.BasePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePage {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        Log.info("Application Launched Successfully");
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleLogoTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

        boolean status = loginPage.validateLoginPageLogo();
        Assert.assertTrue(status);
        Log.info("Login Page Title and Logo Verified");
    }

    @Test(priority = 2)
    public void validLoginTest() {
        homePage = loginPage.validateLogin(properties.getProperty("username"), properties.getProperty("password"));
        boolean status = homePage.validateHomePageLogo();
        Assert.assertTrue(status);
        Log.info("Successfully logged into Orange HRM Application");
    }

    @DataProvider(name = "invalidData")
    public Object[][] getLoginInvalidData() {
        return new Object[][]{{"Admin", " "},
                {"admin", "12345"},
                {"1234", "admin"},
                {" ", " "}
        };
    }

    @Test(priority = 3, dataProvider = "invalidData")
    public void invalidLoginTest(String username, String password) {
        loginPage.validateLogin(username, password);
        String invalidMessage = loginPage.validateInvalidLoginMessage();
        Assert.assertEquals(invalidMessage, Constants.LOGIN_PAGE_ERROR_MESSAGE);
        Log.info("Invalid login verified");
    }

}
