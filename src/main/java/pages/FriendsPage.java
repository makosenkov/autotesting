package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CardTransformer;
import utilities.CardWrapper;

import java.util.ArrayList;
import java.util.List;

public class FriendsPage extends BasePage {
    private static final String FRIEND_CARDS = "$x(\"//*[@class='user-grid-card_img']\")";
    private WebDriver driver;

    public FriendsPage(WebDriver driver) {
        this.driver = driver;
        if (!check(driver)) {
            throw new IllegalArgumentException();
        }
    }

    public List<CardWrapper> getFriendsCardWrappers() {
        List<WebElement> cards = getFriendCards();
        List<CardWrapper> wrappedCards = new ArrayList<>();
        for (WebElement card: cards) {
            wrappedCards.add(CardTransformer.wrap(card));
        }
        return wrappedCards;
    }

    private List<WebElement> getFriendCards() {
        return driver.findElements(By.xpath(FRIEND_CARDS));
    }

    @Override
    boolean check(WebDriver driver) {
        return getFriendCards() != null;
    }
}
