package waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    public static ExpectedCondition<Boolean> jQueryAJAXsCompleted(){
        return new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0").equals(true);
            }
        };
    }

}
