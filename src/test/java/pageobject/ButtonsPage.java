package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonsPage extends BasePage {
    private By clickMeButtonLocator = By.xpath("//button[text()='Click Me']");
    private By messageElementLocator = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void clickClickMeButton() {
        WebElement clickMeButton = findElement(clickMeButtonLocator);
        clickMeButton.click();
    }

    public WebElement getMessageElementLocator() {
        return findElement(messageElementLocator);
    }

    public String getMessage() {
        WebElement messageElement = getMessageElementLocator();
        return messageElement.getText();
    }
}
