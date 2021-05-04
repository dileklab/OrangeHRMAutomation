package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import com.orangehrm.utilities.ElementUtil;
import com.orangehrm.utilities.StaticWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends BasePage {

    @FindBy(xpath = "//b[contains(text(),'PIM')]")
    private WebElement clickPIM;

    @FindBy(id = "menu_pim_addEmployee")
    private WebElement addEmployee;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "btnSave")
    private WebElement btnSave;

    @FindBy(xpath = "//h1[contains(text(),'Add Employee')]")
    private WebElement pageHeader;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    public String getAddEmployeePageHeader() {
        clickOnPIM();
        return ElementUtil.doGetText(pageHeader);
    }

    public void clickOnPIM() {
        ElementUtil.moveToElement(driver, clickPIM);
        ElementUtil.waitForElementToBeVisible(driver, addEmployee, 10);
        ElementUtil.doClick(addEmployee);
    }

    public void addEmployee(String fName, String lName) {
        ElementUtil.doSendKeys(firstName, fName);
        ElementUtil.doSendKeys(lastName, lName);
        StaticWaits.staticShortWait();
        ElementUtil.doClick(btnSave);
    }

}
