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
    private double rentAmountPerMonth = 0.0;
    private String searchTerm = "Google Cloud Platform Pricing Calculator";


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
        waitForElementLocatedBy(driver, By.className("devsite-doc-set-nav-row"));
        Assert.assertTrue(driver.findElement(By.className("devsite-doc-set-nav-row")).isDisplayed(), "Necessary page is opened");
    }

    @Test(description = "Simple compute engine estimation", dependsOnMethods = "necessaryPageOpen")
    public void calculatePrice() {
        GoogleCloudPlatformPricingCalculatorPage estimation = new GoogleCloudPlatformPricingCalculatorPage(driver)
                .activateSection()
                .fillForm();
        //        .addToEstimate();
   //     Assert.assertTrue(estimation, "Estimation is done");
    }

//    @Test(description = "Verification of the data conformity", dependsOnMethods = "calculatePrice")
//    public void verifyInputDataConformity() {
//        boolean dataVerification = new GoogleCloudPlatformPricingCalculatorPage(driver)
//                .checkVMClass()
//                .checkInstanceType()
//                .checkRegion()
//                .checkLocalSSD()
//                .checkCommitmentTerm();
//        Assert.assertTrue(dataVerification, "Data matches the entered data");
//    }
//
//    @Test(description = "Verification of the conformity of the rental amount per month with the amount obtained by manually passing the test", dependsOnMethods = "verifyInputDataConformity")
//    public void verifyDataConformityWithManualTestAmount() {
//        double conformityVerification = new GoogleCloudPlatformPricingCalculatorPage(driver)
//                .findRentAmountPerMonthWithAutomatedTest();
//        Assert.assertEquals(rentAmountPerMonth, conformityVerification);
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
