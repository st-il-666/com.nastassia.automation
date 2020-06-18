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

    @FindBy(xpath = "//*[@id=\"select_option_213\"]/div")
    private WebElement standardEightType;

    @FindBy(xpath = "//*[@id=\"mainForm\"]//md-checkbox/div[1]")
    private WebElement checkboxGPUs;

    @FindBy(id = "select_option_342")
    private WebElement numberOfGPUs;

    @FindBy(id = "select_value_label_336")
    private WebElement typeGPU;

    @FindBy(id = "select_value_label_169")
    private WebElement localSSDBox;

    @FindBy(id = "select_value_label_56")
    private WebElement dataCenterLocation;

    @FindBy(id = "select_value_label_96")
    private WebElement committedUsage;

    @FindBy(xpath = "//*[@id=\"select_option_342\"]/div")
    private WebElement necessaryNumberOfGPUs;

    @FindBy(xpath = "//*[@id=\"select_option_105\"]/div")
    private WebElement necessaryCommittedUsage;

    @FindBy(xpath = "//*[@id=\"select_option_234\"]/div[1]")
    private WebElement necessaryLocalSSD;

    @FindBy(xpath = "//*[@id=\"select_option_349\"]/div")
    private WebElement necessaryTypeOfGPUs;

    @FindBy(xpath = "//*[@id=\"select_option_181\"]/div")
    private WebElement necessaryLocation;


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
        WebDriverWait wait = new WebDriverWait(driver, 20);
        instancesNumber.sendKeys("4");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        ClickWithJSExecutor(executor, "arguments[0].click();", software);
        softwareOption.click();
        wait.until(ExpectedConditions.elementToBeClickable(regularVMDropdown));

        ClickWithJSExecutor(executor, "arguments[0].scrollIntoView();", regularVMDropdown);
        ClickWithJSExecutor(executor, "arguments[0].click();", regularVMDropdown);
        regularVM.click();

        ClickWithJSExecutor(executor, "arguments[0].click();", machineType);
        standardEightType.click();

        ClickWithJSExecutor(executor, "arguments[0].click();", checkboxGPUs);
        ClickWithJSExecutor(executor, "arguments[0].click();", numberOfGPUs);
        necessaryNumberOfGPUs.click();
        ClickWithJSExecutor(executor, "arguments[0].click();", typeGPU);
        if (!necessaryTypeOfGPUs.isEnabled()){
            System.out.println("Sorry, this GPU type is disabled");
        }
        necessaryTypeOfGPUs.click();

        ClickWithJSExecutor(executor, "arguments[0].scrollIntoView();", localSSDBox);
        ClickWithJSExecutor(executor, "arguments[0].click();", localSSDBox);
        necessaryLocalSSD.click();

        ClickWithJSExecutor(executor, "arguments[0].click();", dataCenterLocation);
        necessaryLocation.click();

        ClickWithJSExecutor(executor, "arguments[0].click();", committedUsage);
        necessaryCommittedUsage.click();

        return this;
    }

    private void ClickWithJSExecutor(JavascriptExecutor executor, String s, WebElement dataCenterLocation) {
        executor.executeScript(s, dataCenterLocation);
    }

}
