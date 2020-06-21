package hurt_my_plenty.page;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatformPricingCalculatorPage {

    private final WebDriver driver;

    @FindBy(xpath = "//md-pagination-wrapper/md-tab-item[1]//div[@class='hexagon-in2']")
    private WebElement computeEngine;

    @FindBy(id = "input_58")
    private WebElement instancesNumber;

    @FindBy(xpath = "//md-select-value[contains (@class, 'md-select-value') and contains (@id, 'select_value_label_51')]")
    private WebElement software;

    @FindBy(id = "select_option_1000")
    private WebElement operatingSystemFREE;

    @FindBy(xpath = "//*[@id=\"select_option_60\"]/div[1]")
    private WebElement softwareOption;

    @FindBy(id = "select_container_71")
    private WebElement selectSoftwareContainer;

    @FindBy(xpath = "//*[@id=\"select_option_72\"]/div")
    private WebElement regularVM;

    @FindBy(id = "select_value_label_52")
    private WebElement regularVMDropdown;

    @FindBy(id = "select_value_label_55")
    private WebElement machineType;

    @FindBy(css = "#select_option_213")
    private WebElement standardEightType;

    @FindBy(xpath = "//*[@id=\"mainForm\"]//md-checkbox/div[1]")
    private WebElement checkboxGPUs;

    @FindBy(id = "select_337")
    private WebElement numberOfGPUs;

    @FindBy(id = "select_value_label_336")
    private WebElement typeGPU;

    @FindBy(id = "select_value_label_169")
    private WebElement localSSDBox;

    @FindBy(id = "select_value_label_56")
    private WebElement dataCenterLocation;

    @FindBy(id = "resultBlock")
    private WebElement estimationResultBlock;

    @FindBy(id = "select_value_label_96")
    private WebElement committedUsage;

    @FindBy(css = "#select_option_342")
    private WebElement necessaryNumberOfGPUs;

    @FindBy(css = "#select_option_90")
    private WebElement necessaryCommittedUsage;

    @FindBy(css = "#select_option_234")
    private WebElement necessaryLocalSSD;

    @FindBy(css = "#select_option_349")
    private WebElement necessaryTypeOfGPUs;

    @FindBy(css = "#select_option_181")
    private WebElement necessaryLocation;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div[@class='layout-align-end-start layout-row']/button[@type='button']")
    private WebElement addToEstimate;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(), 'regular')]")
    private WebElement classVMResult;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(), 'n1-standard-8')]")
    private WebElement instanceTypeResult;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(), 'Frankfurt')]")
    private WebElement regionResult;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(), '2x375')]")
    private WebElement localSSDSpaceResult;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(), '1 Year')]")
    private WebElement commitmentTermResult;

    @FindBy(xpath = "//b[@class='ng-binding']")
    private WebElement totalEstimatedCostElement;

    @FindBy(xpath = "//md-content[@id='compute']//*[text()='USD - US Dollar']")
    private WebElement rentAmountPerMonth;


    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPlatformPricingCalculatorPage activateSection() {
        driver.switchTo().frame(0);
        WebElement childFrameElement = driver.findElement(By.id("myFrame"));
        driver.switchTo().frame(childFrameElement);
        if (!computeEngine.isSelected()) {
            computeEngine.click();
        }
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillForm() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 20);
        instancesNumber.sendKeys("4");
        ClickWithJSExecutor(executor, "arguments[0].click();", software);
        wait.until(ExpectedConditions.visibilityOf(softwareOption));
        ClickWithJSExecutor(executor, "arguments[0].click();", softwareOption);

        wait.until(ExpectedConditions.elementToBeClickable(regularVMDropdown));
        ClickWithJSExecutor(executor, "arguments[0].scrollIntoView();", regularVMDropdown);
        ClickWithJSExecutor(executor, "arguments[0].click();", regularVMDropdown);
        ClickWithJSExecutor(executor, "arguments[0].click();", regularVM);

        ClickWithJSExecutor(executor, "arguments[0].click();", machineType);
        wait.until(ExpectedConditions.visibilityOf(standardEightType));
        ClickWithJSExecutor(executor, "arguments[0].click();", standardEightType);

        ClickWithJSExecutor(executor, "arguments[0].click();", checkboxGPUs);
        wait.until(ExpectedConditions.visibilityOf(numberOfGPUs));
        ClickWithJSExecutor(executor, "arguments[0].click();", numberOfGPUs);
        ClickWithJSExecutor(executor, "arguments[0].click();", necessaryNumberOfGPUs);
        ClickWithJSExecutor(executor, "arguments[0].click();", typeGPU);
        if (!necessaryTypeOfGPUs.isEnabled()) {
            System.out.println("Sorry, this GPU type is disabled");
        }
        ClickWithJSExecutor(executor, "arguments[0].click();", necessaryTypeOfGPUs);

        ClickWithJSExecutor(executor, "arguments[0].scrollIntoView();", localSSDBox);
        ClickWithJSExecutor(executor, "arguments[0].click();", localSSDBox);
        ClickWithJSExecutor(executor, "arguments[0].click();", necessaryLocalSSD);

        ClickWithJSExecutor(executor, "arguments[0].click();", dataCenterLocation);
        wait.until(ExpectedConditions.visibilityOf(necessaryLocation));
        ClickWithJSExecutor(executor, "arguments[0].click();", necessaryLocation);

        ClickWithJSExecutor(executor, "arguments[0].click();", committedUsage);
        ClickWithJSExecutor(executor, "arguments[0].click();", necessaryCommittedUsage);

        return this;
    }

    public boolean addToEstimate() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 20);

        ClickWithJSExecutor(executor, "arguments[0].scrollIntoView();", addToEstimate);
        wait.until(ExpectedConditions.visibilityOf(addToEstimate));
        executor.executeScript("arguments[0].click();", addToEstimate);
        wait.until(ExpectedConditions.visibilityOf(estimationResultBlock));
        return driver.findElement(By.id("resultBlock")).isDisplayed();
    }

    public boolean checkVMClass(){
        return classVMResult.isDisplayed();
    }

    public boolean checkInstanceType(){
        return instanceTypeResult.isDisplayed();
    }

    public boolean checkRegion(){
        return regionResult.isDisplayed();
    }

    public boolean checkLocalSSD(){
        return localSSDSpaceResult.isDisplayed();
    }
    public boolean checkCommitmentTerm(){
        return commitmentTermResult.isDisplayed();
    }

    public String findRentAmountPerMonthWithAutomatedTest(){
        return totalEstimatedCostElement.getText();
    }



    private void ClickWithJSExecutor(JavascriptExecutor executor, String s, WebElement dataCenterLocation) {
        executor.executeScript(s, dataCenterLocation);
    }

}
