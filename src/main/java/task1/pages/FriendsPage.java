package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import task1.utilities.CardWrapper;
import task1.utilities.CardTransformer;

import java.util.ArrayList;
import java.util.List;

public class FriendsPage extends BasePage {
    private static final String FRIEND_CARDS = ".//*[@class='user-grid-card']";
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

    private List<WebElement> getFriendCards() {
        List<WebElement> elements = driver.findElements(By.xpath(FRIEND_CARDS));
        return elements;
    }

    public WebElement getFriendCardsHolder() {
        return driver.findElement(By.id(FRIEND_CARDS_HOLDER));
    }

    @Override
    boolean check(WebDriver driver) {
        return getFriendCards() != null && getFriendCardsHolder() != null;
    }
}
