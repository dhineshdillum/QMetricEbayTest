package QMetricEbayGp.TestClasses;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonActions;
import utils.WebDriverConfigurer;

/**
 * Created by dhinesh.dillum on 25/04/17.
 */
public class SearchResultPage extends WebDriverConfigurer {

    public static final By sortByField = By.xpath("//*[@id='DashSortByContainer']//*[@class='sel']");
    public static final By postage = By.xpath("//*[@id='ListViewInner']/li[1]//*[@class='lvshipping']");
    public static final By bid = By.xpath("//*[@id='ListViewInner']/li[1]//*[@class='lvformat']/span");
    public static final By price = By.xpath("//*[@id='ListViewInner']/li[1]//*[@class='lvprice prc']");

    CommonActions ca = new CommonActions(driver);

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void sortSearchResultBy(String sortType) {
        driver.findElement(sortByField).click();
        driver.findElement(By.xpath("//*[@id='SortMenu']//*[text()='"+sortType+"']")).click();
    }

    public void filterSearchResultBy(String filterType) {
        driver.findElement(By.xpath("//*[@class='asp pnl left']//*[@title='"+filterType+"']")).click();
    }

//    public void assertPostage (String expectedPostage) {
//        ca.assertEqualTest(expectedPostage, postage);
//    }
    public void assertPostage(String expectedPostage) {
        String actualText = driver.findElement(postage).getText();
        Assert.assertTrue(actualText.contains("Free"));
    }

    public void confirmBidIsPresent(String expectedBid) {
        String actualText = driver.findElement(bid).getText();
        Assert.assertTrue(actualText.contains(expectedBid));
    }

    public void confirmPriceIsPresent() {
        String actualText = driver.findElement(price).getText();
        Assert.assertTrue(actualText.contains("£"));
    }
}
