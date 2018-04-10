package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleResultPage;
import pages.GoogleSearchPage;

import java.util.List;

public class GoogleSearchTest extends BaseTest{

    /**
     * Test which open google.com in web browser,
     * search for "Selenium" and verify results on first 2 pages.
     */
    @Test
    public void basicSearchTest() {
        String searchTerm = "selenium";

        GoogleResultPage resultPageOne = searchPage.searchByTerm(searchTerm);
        List<String> resultsPageOne = resultPageOne.getResults();

        Assert.assertEquals(resultsPageOne.size(), 10, "Number of results is wrong on page one");

        for (String result : resultsPageOne) {
            Assert.assertTrue(result.toLowerCase().contains(searchTerm),
                    "Searchterm "+searchTerm+ " not found in cart ");
        }

        GoogleResultPage resultPageTwo = resultPageOne.clickPageTwo();
        List<String> resultsPageTwo = resultPageTwo.getResults();

        Assert.assertEquals(resultsPageTwo.size(), 10, "Number of results is wrong on page two");

        for (String result : resultsPageTwo) {
            Assert.assertTrue(result.toLowerCase().contains(searchTerm),
                    "Searchterm " + searchTerm + " not found in cart ");
        }
    }
}
