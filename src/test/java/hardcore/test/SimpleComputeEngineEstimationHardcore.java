package hardcore.test;

import hardcore.page.GoogleCloudPageHardcore;
import hardcore.page.GoogleCloudPlatformPricingCalculatorPageHardcore;
import hardcore.page.SearchResultsPageHardcore;
import hardcore.page.TenMinuteMailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SimpleComputeEngineEstimationHardcore {

    private WebDriver driver;
    private final String expectedRentAmountPerMonth = "1,082.77";
    private final String searchTerm = "Google Cloud Platform Pricing Calculator";
    private String tenMinuteMailCopy;


    @BeforeSuite(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test(description = "Page with search Results open test")
    public void searchResultsPageOpen() {
        GoogleCloudPageHardcore googleCloudSearch = new GoogleCloudPageHardcore(driver)
                .openPage()
                .searchTerm(searchTerm);
        waitForElementLocatedBy(driver, By.className("devsite-article-body"));
        Assert.assertTrue(driver.findElement(By.className("devsite-article")).isDisplayed(), "Page with search Results is not opened");
    }

    @Test(description = "Necessary page open test", dependsOnMethods = "searchResultsPageOpen")
    public void necessaryPageOpen() {
        SearchResultsPageHardcore calculatePageOpen = new SearchResultsPageHardcore(driver)
                .openNecessaryPage(searchTerm);
        waitForElementLocatedBy(driver, By.className("devsite-main-content"));
        Assert.assertTrue(driver.findElement(By.className("devsite-main-content")).isDisplayed(), "Necessary page is not opened");
    }

    @Test(description = "Simple compute engine estimation", dependsOnMethods = "necessaryPageOpen")
    public void calculatePrice() {
        boolean estimation = new GoogleCloudPlatformPricingCalculatorPageHardcore(driver)
                .activateSection()
                .fillForm()
                .addToEstimate();
        Assert.assertTrue(estimation, "Estimation is not done");
    }

    @Test(description = "Email estimation modal window opens", dependsOnMethods = "calculatePrice")
    public void emailEstimationModalWindowOpen() {
        GoogleCloudPlatformPricingCalculatorPageHardcore emailEstimation = new GoogleCloudPlatformPricingCalculatorPageHardcore(driver)
                .emailEstimateFormOpen();
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div.md-dialog-container.ng-scope")).isDisplayed(), "Email estimation modal window is not opened");
    }

    @Test(description = "Ability to copy ten minutes mail", dependsOnMethods = "emailEstimationModalWindowOpen")
    public void tenMinuteEmailCopy() throws IOException, UnsupportedFlavorException {
        tenMinuteMailCopy = new TenMinuteMailPage(driver)
                .tenMinuteMailSiteOpen()
                .copyTenMinuteMail();
        Assert.assertFalse(tenMinuteMailCopy.isEmpty(), "Ten minutes mail is not copied");
    }

    @Test(description = "Filling the email field and sending the total cost test", dependsOnMethods = "tenMinuteEmailCopy")
    public void emailEstimationFormFill() {
        String sendEmail = new GoogleCloudPlatformPricingCalculatorPageHardcore(driver)
                .emailFormFill(tenMinuteMailCopy);
        Assert.assertFalse(sendEmail.isEmpty(), "Email is not sent");
    }

//    @Test(description = "Correspondence of the total estimated monthly cost from the letter", dependsOnMethods = "tenMinuteEmailCopy")
//    public void emailEstimationFormFill() {
//        GoogleCloudPlatformPricingCalculatorPageHardcore expectedResult = new GoogleCloudPlatformPricingCalculatorPageHardcore(driver)
//                .emailFormFill();
//        .getTotalEstimatedMonthlyCostFromMail();
//        Assert.assertTrue( , "The total estimated monthly cost in the letter is not the same as what is displayed in the calculator");
//    }

    @AfterSuite(alwaysRun = true)

    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
