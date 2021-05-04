package com.orangehrm.base;

import com.orangehrm.utilities.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected static WebDriver driver;
    protected static Properties properties;
    protected static Logger Log;

    public BasePage() {
        Log = LogManager.getLogger(this.getClass());
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream("./src/main/java/com/orangehrm/config/config.properties");
            properties.load(file);
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Config file not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception");
        }
    }

    public static void initializeDriver() {
        String browserName = properties.getProperty("browser");
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(OptionsManager.getChromeOptions());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                System.out.println("Browser not found");
                break;
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));
    }


    public String getScreenshot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        Log.info("Browser Terminated");
        Log.info("-----------------------------------------------");
    }

}
