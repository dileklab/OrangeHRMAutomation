package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import com.orangehrm.utilities.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='branding']//a//img")
    private WebElement logo;

    @FindBy(xpath = "//div[@class='quickLaunge']//span")
    private List<WebElement> quickLaunchItems;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateHomePageLogo() {
        return ElementUtil.doIsDisplayed(logo);
    }

    public String validateHomePageTitle(){
        return ElementUtil.doGetPageTitle();
    }

    public ArrayList<String> validateQuickLaunchItems() {
        ArrayList<String> quickLaunchItemsText = new ArrayList<String>();
        for (WebElement element : quickLaunchItems) {
            String text = ElementUtil.doGetText(element);
            quickLaunchItemsText.add(text);
        }
        return quickLaunchItemsText;
    }

    public String getHomePageUrl() {
        return ElementUtil.doGetPageUrl();
    }

}
