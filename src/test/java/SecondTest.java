import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecondTest {

    public static void main(String[] args) {
        // Встановлення шляху до ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");

        // Ініціалізація веб-драйвера
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Явное ожидание на 20 секунд

        // Відкриття сторінки
        driver.get("https://demoqa.com/webtables");

        // Натискання кнопки ADD
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        // Заповнення форми додавання
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        firstNameField.sendKeys("John");

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Doe");

        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("johndoe@example.com");

        WebElement ageField = driver.findElement(By.id("age"));
        ageField.sendKeys("30");

        WebElement salaryField = driver.findElement(By.id("salary"));
        salaryField.sendKeys("50000");

        WebElement departmentField = driver.findElement(By.id("department"));
        departmentField.sendKeys("IT");

        // Збереження запису
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Очікування після додавання запису
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/webtables"));

        // Перевірка, що запис додався
        WebElement addedRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'John Doe')]")));
        if (addedRecord.isDisplayed()) {
            System.out.println("Запис доданий успішно.");
        } else {
            System.out.println("Помилка: запис не доданий.");
        }

        // Редагування запису
        WebElement editButton = addedRecord.findElement(By.xpath("./following-sibling::div[contains(@class, 'edit')]"));
        editButton.click();

        WebElement editedSalaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salary")));
        editedSalaryField.clear();
        editedSalaryField.sendKeys("60000");

        WebElement saveButton = driver.findElement(By.id("submit"));
        saveButton.click();

        // Перевірка, що запис відредагований
        WebElement editedRecordSalary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'John Doe')]/following-sibling::div[contains(@class, 'salary')]")));
        String editedSalary = editedRecordSalary.getText();
        if (editedSalary.equals("60000")) {
            System.out.println("Запис успішно відредагований.");
        } else {
            System.out.println("Помилка: запис не відредагований.");
        }

        // Закриття веб-драйвера
        driver.quit();
    }
}
