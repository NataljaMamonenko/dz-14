package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditRecordTest extends BaseTest {

    // Ініціалізація об'єкту WebDriverWait
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

       public void run() {

        // Відкриття сторінки
        driver.get("https://demoqa.com/webtables");

        // Натискання кнопки ADD
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        // Збереження запису
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

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
    }
}
