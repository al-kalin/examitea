package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.GoogleSearchPage;

public class BaseTest {
    WebDriver driver;
    GoogleSearchPage searchPage;

    /**
     * Switch for use different browsers.
     * there are two browsers available to use: firefox or chrome, default - firefox.
     * get link "https://www.google.com/" and open page of GoogleSearchPage class
     * @param browserType - browser which will used in the test
     */
    @Parameters({"browserType"})

    @BeforeMethod
    public void beforTest(@Optional("firefox")String browserType) {

        switch (browserType.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Unsupported browser");
                break;
        }

        driver.get("https://www.google.com/");
        searchPage = new GoogleSearchPage(driver);
    }

    /**
     * close driver after test
     */
    @AfterMethod
    public void afterTest() {
        driver.close();
    }
}
