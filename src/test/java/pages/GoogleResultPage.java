package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleResultPage extends BasePage {

    /**
     * locator for user resultsWebElementList web element
     */
    @FindBy(xpath = "//*[@class='srg']//h3")
    private List<WebElement> resultsWebElementList;

    /**
     * locator for user pageTwoLink web element
     */
    @FindBy(xpath = "//*[@aria-label='Page 2']")
    private WebElement pageTwoLink;

    /**
     * locator for user resultsNumber web element
     */
    @FindBy(id = "resultStats")
    private WebElement resultsNumber;

    /**
     * Constructor of GoogleResultPage class that takes WebDriver instance from BasePage class
     * and initialise GoogleResultPage WebElements via PageFactory.
     * @param driver - WebDriver instance
     */
    public GoogleResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Wait until resultsNumber is visible.
     * get search results titles into List
     * @return - List of Strings with search result titles
     */
    public List<String> getResults() {
        waitUntilElementIsVisible(resultsNumber, 30);
        List<String> resultsStringList = new ArrayList();
        for (WebElement result : resultsWebElementList) {
            String cardTitle = result.getText();
            resultsStringList.add(cardTitle);
        }
        return resultsStringList;
    }

    /**
     * Clicks on second page of Search results
     * @return - second page of Search results
     */
    public GoogleResultPage clickPageTwo(){
        pageTwoLink.click();
        return new GoogleResultPage(driver);
    }
}
