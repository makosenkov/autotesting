package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CardTransformer;
import utilities.CardWrapper;

import java.util.ArrayList;
import java.util.List;

public class FriendsPage extends BasePage {
    private static final String FRIEND_CARDS = "user-grid-card";
    private static final String FRIEND_CARDS_HOLDER = "hook_Block_MyFriendsSquareCardsPagingB";
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

    public List<WebElement> getFriendCards() {
        return driver.findElements(By.className(FRIEND_CARDS));
    }

    public WebElement getFriendCardsHolder() {
        return driver.findElement(By.id(FRIEND_CARDS_HOLDER));
    }

    @Override
    boolean check(WebDriver driver) {
        return getFriendCards() != null && getFriendCardsHolder() != null;
    }
}
