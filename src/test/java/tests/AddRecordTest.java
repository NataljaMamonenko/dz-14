package tests;

import org.testng.annotations.Test;
import pageobject.WebTablesPage;

public class AddRecordTest extends BaseTest {

    @Test
    public void addNewRecordTest() {
        String userEmail = "johndoe@gmail.com";

        new WebTablesPage(driver)
                .openWebTablesPage()
                .clickAddNewRecordButton()
                .fillNewRecordForm("Doe", "John", "johndoe@gmail.com", "30", "50000", "IT")
                .assertUserIsDisplayed(userEmail);
    }
}

