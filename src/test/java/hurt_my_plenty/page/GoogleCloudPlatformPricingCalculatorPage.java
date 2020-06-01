package hurt_my_plenty.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPlatformPricingCalculatorPage {

    private final WebDriver driver;

    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
