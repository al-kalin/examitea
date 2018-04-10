package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    /**
     * Constructor of BasePage class which takes Web Driver instance initialized in @BeforeMethod
     * for reuse in BasePage class methods
     * @param driver - WebDriver instance
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Wait until WebElement is Clickable on Web page
     * @param webElement - WebElement to Wait for
     * @param timeOutInSeconds - time to wait
     */
    public void waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Wait until WebElement is Visible on Web page
     * @param webElement - WebElement to Wait for
     * @param timeOutInSeconds - time to wait
     */
    public void waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
