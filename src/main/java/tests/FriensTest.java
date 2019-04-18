package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utilities.CardWrapper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class FriensTest extends TestBase {
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private String targetFriendName;
    private String messageForFriend;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://ok.ru/";
        targetFriendName = "Денис Графов";
        messageForFriend = "отправлено из жабы, тестирую твою жопу";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() throws Exception {
        driver.get(baseUrl + "/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clearField(loginPage.getLoginField());
        loginPage.sendKeys(loginPage.getLoginField(), "89681874221");
        loginPage.clearField(loginPage.getPasswordField());
        loginPage.sendKeys(loginPage.getPasswordField(), "123456*Mak");
        loginPage.clickSubmit(loginPage.getSubmitField());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        UserMainPage mainPage = new UserMainPage(driver);
        mainPage.click(mainPage.getFriendsField());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        FriendsPage friendsPage = new FriendsPage(driver);

        List<CardWrapper> cards = friendsPage.getFriendsCardWrappers();
        assertNotNull(cards);
        for (CardWrapper card: cards) {
            if (card.getName().equals(targetFriendName)) {
                card.clickWrite();
            }
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        ChatPage chatPage = new ChatPage(driver);
        chatPage.writeMessage(messageForFriend);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }



}
