package hardcore.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class TenMinuteMailPage {
    private WebDriver driver;

    @FindBy(id = "mail_address")
    private WebElement temporaryMail;

    @FindBy(className = "copy_icon")
    private WebElement copyIcon;

    @FindBy(className = "mail_address")
    private WebElement mailAddressForm;

    public TenMinuteMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TenMinuteMailPage tenMinuteMailSiteOpen() {
        String tenMinutesMailSite = "https://10minutemail.com";
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(tenMinutesMailSite);
        return this;
    }

    public String copyTenMinuteMail() throws IOException, UnsupportedFlavorException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(mailAddressForm));
        copyIcon.click();
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }


    private void ClickWithJSExecutor(JavascriptExecutor executor, String s, WebElement dataCenterLocation) {
        executor.executeScript(s, dataCenterLocation);
    }

}
