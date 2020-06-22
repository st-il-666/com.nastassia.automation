package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPageHardcore {

    private final WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchField;

    public GoogleCloudPageHardcore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPageHardcore openPage() {
        String homePage = "https://cloud.google.com/";
        driver.get(homePage);
        return this;
    }

    public GoogleCloudPageHardcore searchTerm(String term) {
        searchField.click();
        searchField.sendKeys(term);
        searchField.submit();
        return this;
    }

}
