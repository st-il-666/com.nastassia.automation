package hurt_my_plenty.test;

import hurt_my_plenty.page.GoogleCloudPage;
import hurt_my_plenty.page.GoogleCloudPlatformPricingCalculatorPage;
import hurt_my_plenty.page.SearchResultsPage;
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

import java.util.concurrent.TimeUnit;

public class SimpleComputeEngineEstimation {

    private WebDriver driver;
    private final String expectedRentAmountPerMonth = "1,082.77";
    private final String searchTerm = "Google Cloud Platform Pricing Calculator";


    @BeforeSuite(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test(description = "Page with search Results open test")
    public void searchResultsPageOpen() {
        GoogleCloudPage googleCloudSearch = new GoogleCloudPage(driver)
                .openPage()
                .searchTerm(searchTerm);
        waitForElementLocatedBy(driver, By.className("devsite-article-body"));
        Assert.assertTrue(driver.findElement(By.className("devsite-article")).isDisplayed(), "Page with search Results is opened");
    }

    @Test(description = "Necessary page open test", dependsOnMethods = "searchResultsPageOpen")
    public void necessaryPageOpen() {
        SearchResultsPage calculatePageOpen = new SearchResultsPage(driver)
                .openNecessaryPage(searchTerm);
        waitForElementLocatedBy(driver, By.className("devsite-main-content"));
        Assert.assertTrue(driver.findElement(By.className("devsite-main-content")).isDisplayed(), "Necessary page is opened");
    }

    @Test(description = "Simple compute engine estimation", dependsOnMethods = "necessaryPageOpen")
    public void calculatePrice() {
        boolean estimation = new GoogleCloudPlatformPricingCalculatorPage(driver)
                .activateSection()
                .fillForm()
                .addToEstimate();
        Assert.assertTrue(estimation, "Estimation is done");
    }


    @Test(description = "Verification of the VM Class conformity", dependsOnMethods = "calculatePrice")
    public void verifyVMClassConformity() {
        boolean verificationOfVMClass = new GoogleCloudPlatformPricingCalculatorPage(driver)
                .checkVMClass();
        Assert.assertTrue(verificationOfVMClass, "VM Class in the estimation block does not meet the expected result");
    }

    @Test(description = "Verification of the instance type conformity", dependsOnMethods = "calculatePrice")
    public void verifyInputDataConformity() {
        boolean verificationOfInstanceType = new GoogleCloudPlatformPricingCalculatorPage(driver)
                .checkInstanceType();
        Assert.assertTrue(verificationOfInstanceType, "The instance type in the estimation block does not meet the expected result");
    }

    @Test(description = "Verification of the Region conformity", dependsOnMethods = "calculatePrice")
    public void verifyRegionConformity() {
        boolean verificationOfRegion = new GoogleCloudPlatformPricingCalculatorPage(driver)
                .checkRegion();
        Assert.assertTrue(verificationOfRegion, "The Region in the estimation block does not meet the expected result");
    }

    @Test(description = "Verification of the local SSD space conformity", dependsOnMethods = "calculatePrice")
    public void verifyLocalSSDConformity() {
        boolean verificationOfLocalSSD = new GoogleCloudPlatformPricingCalculatorPage(driver)
                .checkLocalSSD();
        Assert.assertTrue(verificationOfLocalSSD, "A total available local SSD space in the estimation block does not meet the expected result");
    }

    @Test(description = "Verification of the commitment term conformity", dependsOnMethods = "calculatePrice")
    public void verifyCommitmentTermConformity() {
        boolean verificationOfCommitmentTerm = new GoogleCloudPlatformPricingCalculatorPage(driver)
                .checkCommitmentTerm();
        Assert.assertTrue(verificationOfCommitmentTerm, "The commitment term in the estimation block does not meet the expected result");
    }

    @Test(description = "Verification of the conformity of the rental amount per month with the amount obtained by manually passing the test", dependsOnMethods = "calculatePrice")
    public void verifyRentalAmountCoincideWithManualTestAmount() {
        String rentAmountPerMonthWithAutomatedTest = new GoogleCloudPlatformPricingCalculatorPage(driver)
                .findRentAmountPerMonthWithAutomatedTest();
        Assert.assertTrue(rentAmountPerMonthWithAutomatedTest.contains(expectedRentAmountPerMonth), "The rental amount per month does not coincide with the amount obtained by passing the test manually");
    }

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
