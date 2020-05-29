package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import waits.CustomConditions;

import java.util.List;

public class WebDriverSeleniumHQTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
    }

    @Test (description = "Just first test, JIRA binding can be here")
    public void commonSearchTermResults() {

        driver.get("https://mvnrepository.com/");

//        new WebDriverWait(driver, 10)
//                .until(CustomConditions.jQueryAJAXsCompleted());

        WebElement searchInput = waitForElementLocatedBy(driver, By.id("query"));
        searchInput.sendKeys("selenium java");

        List<WebElement> searchBtn = driver.findElements(By.className("button"));
        searchBtn.get(0).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//div[contains (@class,'im') and contains (., 'selenium') and contains (., 'java')]")));

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains (@class, 'im') and contains (., 'selenium') and contains (., 'java')]"));
        System.out.println("Search results number for requested term: " + searchResults.size());
        Assert.assertTrue(searchResults.size() > 0, "Search results are empty!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
