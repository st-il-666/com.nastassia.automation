package i_can_win.test;

import i_can_win.page.PasteCreationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasteCreationTest {
    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Creation of a new paste")
    public void creationOfPasteSuccessful() {
        boolean pasteCreation = new PasteCreationPage(driver)
                .openPage()
                .writeCode("public static void main(String[] args) {\n" +
                        "  System.out.println(\\\"Hello from WebDriver\\\");\" +\n" +
                        "  }")
                .pasteExpiration("10 Minutes")
                .pasteName("helloweb")
                .createPasteSuccessfully();
        Assert.assertTrue(pasteCreation, "Paste is created successfully!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
