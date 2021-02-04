package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Common;

public class GoogleResultsPage {
    private static final By resultsStats = By.id("result-stats");
    private final WebDriver driver;

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isStatsDisplayed() {
        Common.waitForElement(driver, resultsStats);
        WebElement resultsElement = driver.findElement(resultsStats);
        return resultsElement.isDisplayed();
    }

    //TODO: implement this method
    public boolean noStatsDisplayed() {
        return false;
    }

    public void verifySearchResults() {
        WebElement resultsElement = driver.findElement(resultsStats);
        String text = resultsElement.getText();
        String[] arrayOfStrings = text.split(" ");
        String secondElement = arrayOfStrings[1];
        secondElement = secondElement.replace(",", "");
        int number = Integer.parseInt(secondElement);
        boolean isLargeNumber = number > 1000;
        Assert.assertTrue(isLargeNumber);
    }
}
