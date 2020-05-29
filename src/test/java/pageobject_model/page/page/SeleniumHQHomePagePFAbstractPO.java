package pageobject_model.page.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumHQHomePagePFAbstractPO extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://mvnrepository.com/";
    private WebDriver driver;

    @FindBy(id = "query")
    private WebElement searchInput;

    @FindBy(className = "button")
    private WebElement searchButton;

    public SeleniumHQHomePagePFAbstractPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SeleniumHQHomePagePFAbstractPO openPage() {
        driver.get(HOMEPAGE_URL);
        //        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        //                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public SearchResultsPagePFMixedWithAbstractPO searchForTerms(String term) {
        searchInput.sendKeys(term);
        searchButton.click();
        return new SearchResultsPagePFMixedWithAbstractPO(driver, term);

    }
}
