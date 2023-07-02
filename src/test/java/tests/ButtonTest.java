package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.ButtonsPage;

public class ButtonTest {
    private WebDriver driver;
    private ButtonsPage buttonsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        buttonsPage = new ButtonsPage(driver);
        driver.get("https://demoqa.com/elements");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testButtonClick() {
        buttonsPage.clickClickMeButton();
        String message = buttonsPage.getMessage();
        Assert.assertEquals(message, "Button was clicked");
    }
}
