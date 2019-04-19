package task2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import task1.pages.FriendsPage;
import task1.pages.LoginPage;
import task1.utilities.CardWrapper;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class Helper {

    private Helper() {};

    public static void getLogged(LoginPage loginPage) {
        loginPage.clearField(loginPage.getLoginField());
        loginPage.sendKeys(loginPage.getLoginField(), Utilities.LOGIN);
        loginPage.clearField(loginPage.getPasswordField());
        loginPage.sendKeys(loginPage.getPasswordField(), Utilities.PASSWORD);
        loginPage.clickSubmit(loginPage.getSubmitField());
    }

    public static void scroll(int pixels, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    public static CardWrapper findSuitableCard(FriendsPage friendsPage, String targetFriendName) {
        List<CardWrapper> cards = friendsPage.getFriendsCardWrappers();
        assertNotNull(cards);
        for (CardWrapper card: cards) {
            if (card.getName().equals(targetFriendName)) {
                return card;
            }
        }
        return null;
    }
}
