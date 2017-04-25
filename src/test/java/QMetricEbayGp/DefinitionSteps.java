package QMetricEbayGp;

import QMetricEbayGp.TestClasses.EBayTestClass;
import QMetricEbayGp.TestClasses.SearchResultPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by dhinesh.dillum on 25/04/17.
 */
public class DefinitionSteps {

    WebDriver driver;
    EBayTestClass eBayhomepage;
    SearchResultPage searchResultPage;

    @Before
    public void configureDrivers() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/mac/chromedriver2.241");
    }

    @Given("^user opens the ebay homepage$")
    public void user_opens_the_ebay_homepage() throws Throwable {
        eBayhomepage = new EBayTestClass(driver);
        eBayhomepage.openTheeBayHomePage_testEnv();
    }

    @When("^user search for an \"([^\"]*)\"$")
    public void user_search_for_an(String searchKeyword) throws Throwable {
        searchResultPage = eBayhomepage.searchForItem(searchKeyword);
    }

    @When("^user sorts product by \"([^\"]*)\"$")
    public void user_sorts_product_by(String sortType) throws Throwable {
       // searchResultPage = new SearchResultPage(driver);
        searchResultPage.sortSearchResultBy(sortType);
    }

    @When("^user filters by \"([^\"]*)\"$")
    public void user_filters_by(String filterType) throws Throwable {
        searchResultPage.filterSearchResultBy(filterType);
    }

    @Then("^the first item has \"([^\"]*)\"$")
    public void the_first_item_has(String postage) throws Throwable {
        searchResultPage.assertPostage(postage);
    }

    @Given("^the first item has a \"([^\"]*)\" to it$")
    public void the_first_item_has_a_bid_to_it(String bid) throws Throwable {
        searchResultPage.confirmBidIsPresent(bid);
    }

    @Given("^the first item has a price$")
    public void the_first_item_has_a_price() throws Throwable {
        searchResultPage.confirmPriceIsPresent();
    }

    @After
    public void afterTest() {
        driver.quit();
    }

}
