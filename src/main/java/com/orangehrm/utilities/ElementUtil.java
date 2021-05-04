package com.orangehrm.utilities;

import com.orangehrm.base.BasePage;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ElementUtil extends BasePage {

    public static Workbook book;
    public static Sheet sheet;

    public static Actions actions;

    public static String doGetPageTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            System.out.println("some exception got occurred while getting the title");
        }
        return null;
    }

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("some exception got occurred while creating the web element " + locator.toString());
        }
        return element;
    }

    public static boolean doIsDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("some exception got occurred " + element.toString());
        }
        return false;
    }

    public static void doSendKeys(WebElement element, String value) {

        try {
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            System.out.println("some exception got occurred while entering values in a field " + element.toString());
        }
    }

    public static void doClick(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("some exception got occurred while clicking the web element " + element);
        }
    }


    public static String doGetText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            System.out.println("some exception got occurred while getting text " + element);
        }
        return null;
    }

    public static String doGetPageUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            System.out.println("some exception got occurred while getting URL");
        }
        return null;
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
    }


    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(Constants.TEST_DATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
