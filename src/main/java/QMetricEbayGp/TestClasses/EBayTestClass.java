package QMetricEbayGp.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverConfigurer;

/**
 * Created by dhinesh.dillum on 25/04/17.
 */
public class EBayTestClass extends WebDriverConfigurer {
    public static final By searchField = By.xpath("//*[@type='text']");
    public static final By searchButton = By.xpath("//*[@type='submit']");

    public EBayTestClass(WebDriver driver) {
        super(driver);
    }

    public static void openTheeBayHomePage_testEnv() {
        driver.get("http://www.ebay.co.uk");
    }

//    public static void searchForItem(String searchKeyword) {
//        driver.findElement(searchField).sendKeys(searchKeyword);
//        driver.findElement(searchButton).click();
//    }
    public static SearchResultPage searchForItem(String searchKeyword) {
        driver.findElement(searchField).sendKeys(searchKeyword);
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }


}
