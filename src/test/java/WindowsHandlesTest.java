import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsHandlesTest {

    private WebDriver driver;

    @BeforeSuite
    public void setupBeforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/macOs/geckodriver");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void setupAfterSuite() {
        driver.quit();
    }


    //1. Go to main page
    //2. click on link
    //3. verify amount of windows
    //4. verify text and title of the new window
    @Test
    public void testName() {
        navigateToHandlesPage();
        clickOnLink();
        waitForAmountOfWindows(2);
        int amountOfWindows = getAmountOfWindows();
        Assert.assertTrue(amountOfWindows == 2);
        switchToNewWindow();
        verifyTitle("New Window");
    }

    //1. Go to main page
    //2. click on link
    //3. verify amount of windows
    //4. verify text and title of the new window
    @Test
    public void testSwitchToWindowWithTitle() {
        navigateToHandlesPage();
        clickOnLink();
        waitForAmountOfWindows(2);
        int amountOfWindows = getAmountOfWindows();
        Assert.assertTrue(amountOfWindows == 2);
        boolean isSwitched = switchToWindow("New Window");
        Assert.assertEquals(isSwitched, true);
        verifyTitle("New Window");
        boolean textPresented = verifyPageSource("New Window");
        Assert.assertEquals(textPresented, true);
    }

    private boolean verifyPageSource(String textToVerify) {
        String pageSource = driver.getPageSource();
        boolean textPresented = pageSource.contains(textToVerify);
        return textPresented;
    }

    private void waitForAmountOfWindows(final int numberOfWindows) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(driver -> driver.getWindowHandles().size() == numberOfWindows);
    }

    private void verifyTitle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    private boolean switchToWindow(String windowTitle) {
        boolean result = false;

        Set<String> windowHandles = driver.getWindowHandles();
        for (String eachHandle : windowHandles) {
            driver.switchTo().window(eachHandle);
            if (driver.getTitle().equalsIgnoreCase(windowTitle)) {
                result = true;
            }
        }
        return result;
    }

    private void switchToNewWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        String[] strings = windowHandles.toArray(new String[]{});

        String handleOfSecondWindow = strings[1];
        driver.switchTo().window(handleOfSecondWindow);
    }

    private int getAmountOfWindows() {
        Set<String> windowHandles = driver.getWindowHandles();
        int size = windowHandles.size();
        return size;
    }

    private void clickOnLink() {
        WebElement linkElement = driver.findElement(By.linkText("Click Here"));
        linkElement.click();
    }

    private void navigateToHandlesPage() {
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    private void waitFor(int amountOfSeconds) {
        try {
            Thread.sleep(amountOfSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
