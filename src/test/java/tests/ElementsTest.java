package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.ElementsPage;

public class ElementsTest {
    private WebDriver driver;
    private ElementsPage elementsPage;

    @BeforeClass
    public void setUp() {
        // Ініціалізація веб-драйвера
        System.setProperty("webdriver.chrome.driver", "путь_к_файлу_драйвера/chromedriver");
        driver = new ChromeDriver();

        // Перехід на сторінку
        driver.get("http://example.com/elements");

        // Ініціалізація ElementsPage
        elementsPage = new ElementsPage(driver);
    }

    @Test
    public void testClickButtonsLink() {
        // Виклик метода clickButtonsLink()
        elementsPage.clickButtonsLink();
    }

    @AfterClass
    public void tearDown() {
        // Закриття браузера
        driver.quit();
    }
}

