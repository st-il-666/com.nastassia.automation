package i_can_win.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PasteCreationPage {
    private WebDriver driver;
    private static final String URL = "https://pastebin.com/";

    @FindBy(id = "paste_code")
    private WebElement codeInput;

    @FindBy(xpath = "//span[contains(@id, 'select2-paste_expire_date')]")
    private WebElement expirationContainer;

    @FindBy(className = "select2-results__option")
    private List<WebElement> expirationOptions;

    @FindBy(name = "paste_name")
    private WebElement titleField;

    @FindBy(id = "success")
    private WebElement successMessage;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public PasteCreationPage openPage() {
        driver.get(URL);
        return this;
    }

    public PasteCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteCreationPage writeCode(String code) {
        waitForElementLocatedBy(driver, By.id("content_frame"));
        codeInput.sendKeys(code);
        return this;
    }

    public PasteCreationPage pasteExpiration(String expiration) {
        expirationContainer.click();
        for (WebElement option : expirationOptions) {
            if (option.getTagName().toLowerCase().equals(expiration.toLowerCase())) {
                option.click();
                return this;
            }
        }
        return this;
    }

    public PasteCreationPage pasteName(String name) {
        titleField.sendKeys(name);
        return this;
    }

    public boolean createPasteSuccessfully() {
        submitButton.click();
        waitForElementLocatedBy(driver, By.id("content_frame"));
        return successMessage.isDisplayed();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
