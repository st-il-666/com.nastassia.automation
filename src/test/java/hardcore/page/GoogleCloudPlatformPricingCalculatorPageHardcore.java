package hardcore.page;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class GoogleCloudPlatformPricingCalculatorPageHardcore {

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

    @FindBy(id = "email_quote")
    private WebElement emailEstimationButton;

    @FindBy(xpath = "//label[text()='Email ']/following-sibling::input")
    private WebElement emailField;

    @FindBy(xpath = "//iframe")
    private WebElement firstFrame;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public GoogleCloudPlatformPricingCalculatorPageHardcore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPlatformPricingCalculatorPageHardcore activateSection() {
        driver.switchTo().frame(0);
        WebElement childFrameElement = driver.findElement(By.id("myFrame"));
        driver.switchTo().frame(childFrameElement);
        if (!computeEngine.isSelected()) {
            computeEngine.click();
        }
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPageHardcore fillForm() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 20);
        instancesNumber.sendKeys("4");
        useJSExecutor(executor, "arguments[0].click();", software);
        wait.until(ExpectedConditions.visibilityOf(softwareOption));
        useJSExecutor(executor, "arguments[0].click();", softwareOption);

        wait.until(ExpectedConditions.elementToBeClickable(regularVMDropdown));
        useJSExecutor(executor, "arguments[0].scrollIntoView();", regularVMDropdown);
        useJSExecutor(executor, "arguments[0].click();", regularVMDropdown);
        useJSExecutor(executor, "arguments[0].click();", regularVM);

        useJSExecutor(executor, "arguments[0].click();", machineType);
        wait.until(ExpectedConditions.visibilityOf(standardEightType));
        useJSExecutor(executor, "arguments[0].click();", standardEightType);

        useJSExecutor(executor, "arguments[0].click();", checkboxGPUs);
        wait.until(ExpectedConditions.visibilityOf(numberOfGPUs));
        useJSExecutor(executor, "arguments[0].click();", numberOfGPUs);
        useJSExecutor(executor, "arguments[0].click();", necessaryNumberOfGPUs);
        useJSExecutor(executor, "arguments[0].click();", typeGPU);
        useJSExecutor(executor, "arguments[0].click();", necessaryTypeOfGPUs);

        useJSExecutor(executor, "arguments[0].scrollIntoView();", localSSDBox);
        useJSExecutor(executor, "arguments[0].click();", localSSDBox);
        useJSExecutor(executor, "arguments[0].click();", necessaryLocalSSD);

        useJSExecutor(executor, "arguments[0].click();", dataCenterLocation);
        useJSExecutor(executor, "arguments[0].click();", necessaryLocation);

        useJSExecutor(executor, "arguments[0].click();", committedUsage);
        useJSExecutor(executor, "arguments[0].click();", necessaryCommittedUsage);

        return this;
    }

    public boolean addToEstimate() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 20);

        useJSExecutor(executor, "arguments[0].scrollIntoView();", addToEstimate);
        wait.until(ExpectedConditions.visibilityOf(addToEstimate));
        executor.executeScript("arguments[0].click();", addToEstimate);
        wait.until(ExpectedConditions.visibilityOf(estimationResultBlock));
        return driver.findElement(By.id("resultBlock")).isDisplayed();
    }

    public GoogleCloudPlatformPricingCalculatorPageHardcore emailEstimateFormOpen() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        useJSExecutor(executor, "arguments[0].click();", emailEstimationButton);
        return this;
    }

    public String emailFormFill(String mail) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.switchTo().window(tabs.get(0));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.switchTo().frame(firstFrame);
        driver.switchTo().frame("myFrame");
        wait.until(ExpectedConditions.visibilityOf(emailField));
        useJSExecutor(executor, "arguments[0].scrollIntoView();", emailField);
        emailField.sendKeys(mail);
        wait.until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        useJSExecutor(executor, "arguments[0].click();", sendEmailButton);
        return totalEstimatedCostElement.getText()
                .replace("Estimated Component Cost: ", "").replace(" per 1 month", "");
    }

    private void useJSExecutor(JavascriptExecutor executor, String s, WebElement dataCenterLocation) {
        executor.executeScript(s, dataCenterLocation);
    }

}
