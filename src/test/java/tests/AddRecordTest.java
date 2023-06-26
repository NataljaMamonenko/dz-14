package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddRecordTest extends BaseTest {

    public void run() {
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
    }
}

