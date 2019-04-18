package utilities;

import org.openqa.selenium.WebElement;

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
}
