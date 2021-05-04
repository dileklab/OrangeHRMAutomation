package com.orangehrm.tests;

import com.orangehrm.base.BasePage;
import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.Constants;
import com.orangehrm.utilities.ElementUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddEmployeePageTest extends BasePage {

    LoginPage loginPage;
    HomePage homePage;
    AddEmployeePage addEmployeePage;

    public AddEmployeePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        loginPage = new LoginPage();
        homePage = loginPage.validateLogin(properties.getProperty("username"), properties.getProperty("password"));
        addEmployeePage = new AddEmployeePage();
    }

    @Test(priority = 1)
    public void verifyAddEmployeePageHeader() {
        String actual = addEmployeePage.getAddEmployeePageHeader();
        Assert.assertEquals(actual, Constants.ADD_EMPLOYEE_PAGE_HEADER);
        Log.info("Add Employee page header verified");
    }

    @DataProvider
    public Object[][] getContactsTestData() {
        return ElementUtil.getTestData("employee");
    }

    @Test(priority = 2, dataProvider = "getContactsTestData")
    public void addEmployeeTest(String first, String last) {
        addEmployeePage.clickOnPIM();
        addEmployeePage.addEmployee(first, last);
        Log.info("Employee add verified");
    }


}
