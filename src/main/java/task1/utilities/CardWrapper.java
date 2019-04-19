package task1.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CardWrapper {
    private WebElement name;
    private WebElement writeMessage;

    public CardWrapper(WebElement name, WebElement writeMessage) {
        this.name = name;
        this.writeMessage = writeMessage;
    }

    public String getName() {
        return name.getText();
    }

    public void clickWrite() {
        writeMessage.click();
    }

    public void showBar(WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(name).build().perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
