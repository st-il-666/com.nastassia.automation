package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WebDriverSyncDemoFluent {

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new ChromeDriver();

            driver.get("https://www.selenium.dev/");

            new WebDriverWait(driver, 10)
                    .until(CustomConditions.jQueryAJAXsCompleted());

            WebElement searchInput = waitForElementLocatedBy(driver, By.id("gsc-i-id1"));
            searchInput.sendKeys("selenium java");

            List<WebElement> searchBtn = driver.findElements(By.className("search-icon"));
            searchBtn.get(0).click();

            Wait<WebDriver>wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(15))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class)
                    .withMessage("Timeout for waiting search result list was exceeded!");

            List<WebElement> searchResults = wait.until(new Function<WebDriver, List<WebElement>>() {
                @Override
                public List<WebElement> apply(WebDriver driver) {
                    return driver.findElements(By.xpath("//div[contains(@class, 'gsc-webResult') and contains (., 'selenium') and contains (., 'java')]"));
                }
            });

            System.out.println("Search results number for requested term: " + searchResults.size());
            driver.quit();

        }

        private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
            return new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
    }

