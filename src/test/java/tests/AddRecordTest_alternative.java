package tests;

import org.testng.annotations.Test;
import pageobject.WebTablesPage;

public class AddRecordTest_alternative extends BaseTest {

    @Test
    public void addNewRecordTest() {
        String userEmail = "johndoe@example.com";
        new WebTablesPage(driver)
                .openWebTablesPage()
                .clickOnAddNewRecordButton()
                .fillNewRecordForm("John", "Doe", "30", "50000", "IT")
                .assertUserIsAddedInTable(userEmail);

    }


}
