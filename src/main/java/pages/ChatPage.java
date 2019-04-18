package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChatPage extends BasePage {
    private static String CHAT_NAME = "$x(\"//*[@data-l='t,menu_opponent_name']\")";
    private static String ACTIVE_CHAT = "$x(\"//div[@class='chats_i h-mod __active __unreadMy']\")";
    private static String MESSAGE_FIELD = "$x(\"//*[@name='st.txt']\")";
    private static String SEND_MESSAGE = "$x(\"//*[@class='button-pro comments_add-controls_save']\")";
    private WebDriver driver;

    public ChatPage(WebDriver driver) {
        this.driver = driver;
        if (!check(driver)) {
            throw new IllegalArgumentException();
        }
    }

    public WebElement getChatName() {
        return driver.findElement(By.xpath(CHAT_NAME));
    }

    public WebElement getActiveChat() {
        return driver.findElement(By.xpath(ACTIVE_CHAT));
    }

    public WebElement getMessageField() {
        return driver.findElement(By.xpath(MESSAGE_FIELD));
    }

    public WebElement getSendMessage() {
        return driver.findElement(By.xpath(SEND_MESSAGE));
    }

    public void writeMessage(String text) {
        getMessageField().sendKeys(text);
        getSendMessage().click();
    }

    @Override
    boolean check(WebDriver driver) {
        return getActiveChat() != null
            && getChatName() != null
            && getMessageField() != null
            && getActiveChat().getText().equals(getChatName().getText());
    }
}
