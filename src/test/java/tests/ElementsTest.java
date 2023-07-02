package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.ElementsPage;

public class ElementsTest extends BaseTest {
    private ElementsPage elementsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/elements");

        elementsPage = new ElementsPage(driver);
    }

    @Test
    public void testClickButtonsLink() {
        elementsPage.clickButtonsLink();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
