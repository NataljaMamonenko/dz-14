package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.ObjectInputStream;

import static com.codeborne.selenide.Configuration.baseUrl;

public class WebTablesPage extends BasePage {

    private By addNewRecordButton = By.id("addNewRecordButton");
    private By firstNameField  = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By userEmailField = By.id("userEmail");
    private By ageField = By.id("age");
    private By salaryField = By.id("salary");
    private By departmentField = By.id("department");
    private By submitRecordButton = By.id("submit");

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    private By userRecordXpath(String email) {
        return By.xpath(String.format("//div[@class='rt-table']//div[text()='%s']", email));
    }

    public WebTablesPage openWebTablesPage() {
        driver.get(baseUrl + "/webtables");
        return new WebTablesPage(driver);
    }

public WebTablesPage clickOnAddNewRecordButton() {
        getElement(addNewRecordButton).click();
        return this;
    }
public WebTablesPage fillNewRecordForm(String firstName, String lastName, String email, String age, String salary, String department) {
        getElement(firstNameField).sendKeys(firstName);
        getElement(lastNameField).sendKeys(lastName);
        getElement(userEmailField).sendKeys(email);
        getElement(ageField).sendKeys(age);
        getElement(salaryField).sendKeys(salary);
        getElement(departmentField).sendKeys(department);
        getElement(submitRecordButton).click();
        return this;
    }
public WebTablesPage assertUserIsAddedInTables(String email) {
        Assert.assertTrue(getElement(userRecordXpath(email)).isDisplayed(),"Record was not found for email =" + email);
        return this;
    }
}


