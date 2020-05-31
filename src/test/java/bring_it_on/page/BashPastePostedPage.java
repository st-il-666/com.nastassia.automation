package bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BashPastePostedPage {
    private WebDriver driver;

    @FindBy(className = "paste_box_line1")
    private WebElement titleBox;

    @FindBy(id = "code_buttons")
    private WebElement codeActionLine;

    @FindBy(id = "paste_code")
    private WebElement inputCode;


    public BashPastePostedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkTitle(String title) {
        return titleBox.findElement(By.xpath("//h1[contains(text(), \"" + title + "\")]")).isDisplayed();
    }

    public boolean syntaxIsHighlighted(String language) {
        return codeActionLine.findElement(By.xpath("//a[contains(text(),'" + language + "')]")).isDisplayed();
    }

    public boolean checkCode(StringBuffer code) {
        return inputCode.getText().contains(code);
    }

}
