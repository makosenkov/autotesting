package task1.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardTransformer {
    private static final String FRIEND_NAME = ".//div//*[@class='n-t bold']";
    private static final String FRIEND_BUTTON = ".//*[@data-l='t,sendMessage' and " +
        "@class='button-pro __sec __small __ic __send-msg mt-x __wide']";

    private CardTransformer() {};

    public static CardWrapper wrap(WebElement element) {
        WebElement name = element.findElement(By.xpath(FRIEND_NAME));
        WebElement writeMessage = element.findElement(By.xpath(FRIEND_BUTTON));
        return new CardWrapper(name, writeMessage);
    }
}
