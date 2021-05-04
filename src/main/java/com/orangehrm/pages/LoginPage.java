package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import com.orangehrm.utilities.ElementUtil;
import com.orangehrm.utilities.StaticWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@id='divLogo']//img")
    private WebElement logo;

    @FindBy(id = "txtUsername")
    private WebElement username;

    @FindBy(id = "txtPassword")
    private WebElement password;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    @FindBy(id = "spanMessage")
    private WebElement invalidLoginMessage;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        StaticWaits.staticShortWait();
        return ElementUtil.doGetPageTitle();
    }

    public boolean validateLoginPageLogo() {
        return ElementUtil.doIsDisplayed(logo);
    }

    public HomePage validateLogin(String user, String pass) {
        ElementUtil.waitForElementToBeVisible(driver, username, 10);
        ElementUtil.doSendKeys(username, user);
        ElementUtil.waitForElementToBeVisible(driver, password, 10);
        ElementUtil.doSendKeys(password, pass);
        ElementUtil.waitForElementToBeVisible(driver, loginButton, 10);
        StaticWaits.staticShortWait();
        ElementUtil.doClick(loginButton);
        return new HomePage();
    }

    public String validateInvalidLoginMessage() {
        return ElementUtil.doGetText(invalidLoginMessage);
    }
}
