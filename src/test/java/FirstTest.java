import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    public static void main(String[] args) {
        // Встановлення шляху до ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");

        // Ініціалізація веб-драйвера
        WebDriver driver = new ChromeDriver();

        // Відкриття сторінки
        driver.get("https://demoqa.com/elements");

        // Клік на кнопку "Buttons"
        WebElement buttonsLink = driver.findElement(By.xpath("//span[text()='Buttons']"));
        buttonsLink.click();

        // Клік на кнопку "Click Me"
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();

        // Очікування відображення повідомлення
        WebElement messageElement = driver.findElement(By.id("dynamicClickMessage"));
        String message = messageElement.getText();

        // Виведення повідомлення в консоль
        System.out.println("Повідомлення: " + message);

        // Закриття веб-драйвера
        driver.quit();
    }
}


