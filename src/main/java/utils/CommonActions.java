package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dhinesh.dillum on 25/04/17.
 */
public class CommonActions extends WebDriverConfigurer{

    public CommonActions(WebDriver driver) {
        super(driver);
    }

    public void assertEqualTest(String expectedPostage, By postage) {
        String actualText = driver.findElement(postage).getText();
        Assert.assertEquals(expectedPostage, actualText);
    }
}
