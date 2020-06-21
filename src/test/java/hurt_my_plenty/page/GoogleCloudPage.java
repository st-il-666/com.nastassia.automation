package hurt_my_plenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPage {

    private final WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchField;

    public GoogleCloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPage openPage() {
        String homePage = "https://cloud.google.com/";
        driver.get(homePage);
        return this;
    }

    public GoogleCloudPage searchTerm(String term) {
        searchField.click();
        searchField.sendKeys(term);
        searchField.submit();
        return this;
    }

}
