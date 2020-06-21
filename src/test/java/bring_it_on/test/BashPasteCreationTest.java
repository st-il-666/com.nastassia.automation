package bring_it_on.test;

import bring_it_on.page.BashPasteCreationPage;
import bring_it_on.page.BashPastePostedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BashPasteCreationTest {
    private WebDriver driver;
    private String title = "how to gain dominance among developers";
    private String language = "Bash";
    private StringBuffer bashCode = new StringBuffer("git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force");

    @BeforeSuite(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Creation of a new bash paste")
    public void creationOfPaste() {
        boolean pasteCreation = new BashPasteCreationPage(driver)
                .openPage()
                .writeCode(bashCode)
                .pasteSyntaxHighlighting(language)
                .pasteExpiration("10 Minutes")
                .pasteName(title)
                .createGuestPasteSuccessfully();
        Assert.assertTrue(pasteCreation, "Paste is not created!");
    }

    @Test(description = "Validation of a successful title insert", dependsOnMethods = "creationOfPaste")
    public void checkSuccessfulTitleInsert() {
        boolean titleInsert = new BashPastePostedPage(driver)
                .checkTitle(title);
        Assert.assertTrue(titleInsert, "Page title does not match insert Name / Title ");
    }

    @Test(description = "Validation of a successful syntax highlighting", dependsOnMethods = "creationOfPaste")
    public void checkSyntaxHighlighting() {
        boolean codeHighlight = new BashPastePostedPage(driver)
                .syntaxIsHighlighted(language);
        Assert.assertTrue(codeHighlight, "Syntax id is not highlighted for bash");
    }

    @Test(description = "Validation of a successful code insert", dependsOnMethods = "creationOfPaste")
    public void checkCodeInsert() {
        boolean codeInsert = new BashPastePostedPage(driver)
                .checkCode(bashCode);
        Assert.assertTrue(codeInsert, "Code on a successful page does not match the insert code");
    }

    @AfterSuite(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
