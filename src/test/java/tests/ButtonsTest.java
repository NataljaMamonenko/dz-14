package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.ButtonsPage;

public class ButtonsTest {
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

    @Test
    public void testButtonClickWithWait() {
        buttonsPage.clickClickMeButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(buttonsPage.getMessageElementLocator(), "You have done a dynamic click"));
        String message = buttonsPage.getMessage();
        Assert.assertEquals(message, "You have done a dynamic click");
    }
}
