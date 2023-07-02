package tests;

import org.testng.annotations.Test;
import pageobject.WebTablesPage;

public class AddRecordTest extends BaseTest {

    @Test
    public void addNewRecordTest() {
        String userEmail = "johndoe@google.com";
       
       new WebTablesPage(driver)
            .openWebTablesPage()
            .clickOnAddNewRecordButton()
            .fillNewRecordForm("Doe", "John", "johndoe@gooogle.com", "30", "50000", "IT")
            .assertUserIsAddedInTables(userEmail);

    }
}
