package hurt_my_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static hurt_my_plenty.test.SimpleComputeEngineEstimation.waitForElementLocatedBy;

public class SearchResultsPage {

    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "devsite-wrapper")
    private WebElement resultsField;

    public SearchResultsPage openNecessaryPage(String term) {
        waitForElementLocatedBy(driver, By.className("devsite-wrapper"));
        resultsField.findElement(By.xpath("//*[contains(@class, 'gs-title')]//*[contains(text(),'" + term + "')]")).click();
        return this;
    }
}
