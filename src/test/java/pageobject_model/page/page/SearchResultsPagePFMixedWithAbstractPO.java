package pageobject_model.page.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPagePFMixedWithAbstractPO extends AbstractPage {
    private final String splitRegex = "\\s";
    private WebDriver driver;
    private String searchTerm;

    private String defaultLocator = "//div[contains (@class,'im') and contains (., 'selenium') and contains (., 'java')]";
    private String containsPart = " and contains (., '%s')";

    @FindBy(xpath = "//div[contains (@class,'im')]")
    private List<WebElement> generalSearchResults;

    public SearchResultsPagePFMixedWithAbstractPO(WebDriver driver, String searchText) {
        super(driver);
        this.searchTerm = searchText;

        PageFactory.initElements(driver, this);
    }

    public int countGeneralNumberOfSearchResults() {
        System.out.println("Search results number for requested term: " + generalSearchResults.size());
        return generalSearchResults.size();
    }

    public int countResultsNumberWithSearchTerm() {
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.xpath("//div[contains (@class, 'im') and contains (., 'selenium') and contains (., 'java')]"));
        System.out.println("Search results number for requested term: " + resultsNumberWithSearchTerm.size());
        return resultsNumberWithSearchTerm.size();
    }

    private String buildLocatorForSearch() {
        String partWithSearchTerm = "";
        String[] terms = searchTerm.split(splitRegex);
        for (String term : terms) {
            partWithSearchTerm += String.format(containsPart, term);
        }
        String locatorForSearch = String.format(defaultLocator, partWithSearchTerm);
        System.out.println("DEBUG: Final locator with search terms: " + locatorForSearch);
        return locatorForSearch;
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Please think twice...");
    }
}
