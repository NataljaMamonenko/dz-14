package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage extends BasePage {
    private By buttonsLinkLocator = By.xpath("//span[text()='Buttons']");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonsLink() {
        WebElement buttonsLink = findElement(buttonsLinkLocator);
        buttonsLink.click();
    }
}
