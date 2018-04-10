package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends BasePage {

    /**
     * locator for user searchField web element
     */
    @FindBy(id = "lst-ib")
    private WebElement searchField;

    /**
     * locator for user searchButton web element
     */
    @FindBy(name= "btnK")
    private WebElement searchButton;

    /**
     * Constructor of GoogleSearchPage class that takes WebDriver instance from BasePage class
     * and initialize GoogleSearchPage WebElements via PageFactory.
     * @param driver - WebDriver instance
     */
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Wait until searchField is clickable
     * Enter and Submit Term for Search
     * @param searchTerm - Term for Search
     * @return - new page with search results
     */
    public GoogleResultPage searchByTerm(String searchTerm){
        waitUntilElementIsClickable(searchField, 30);
        searchField.sendKeys(searchTerm + "\n");
        return new GoogleResultPage(driver);
    }
}
