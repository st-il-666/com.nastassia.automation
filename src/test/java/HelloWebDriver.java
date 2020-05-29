import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("gsc-i-id1")));
        WebElement searchInput = waitForElementLocatedBy(driver, By.id("gsc-i-id1"));
        searchInput.sendKeys("selenium java");
        WebElement searchBtn = driver.findElement(By.className("search-icon"));
        searchBtn.click();
        driver.quit();

    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
