package task1.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import task1.pages.ChatPage;
import task1.pages.FriendsPage;
import task1.pages.LoginPage;
import task1.pages.UserMainPage;
import task1.utilities.CardWrapper;
import task2.Helper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class FriendsTest extends TestBase {
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private String targetFriendName;
    private String messageForFriend;
    private String suitableRaw;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://ok.ru/";
        targetFriendName = "Денис Графов";
        messageForFriend = "subscribe 2 pewdiepie";
        suitableRaw = ".//*[@class='ic_relation' and @aria-hidden='false']";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() throws Exception {
        driver.get(baseUrl + "/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);

        Helper.getLogged(loginPage);

        UserMainPage mainPage = new UserMainPage(driver);
        mainPage.click(mainPage.getFriendsField());

        FriendsPage friendsPage = new FriendsPage(driver);
        Helper.scroll(500, driver);

        CardWrapper suitableCard = Helper.findSuitableCard(friendsPage, targetFriendName);
        assertNotNull(suitableCard);
        suitableCard.clickWrite();

        ChatPage chatPage = new ChatPage(driver);
        chatPage.writeMessage(messageForFriend);


        driver.findElement(By.xpath(".//*[@data-l='t,closeLayer']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        friendsPage = new FriendsPage(driver);
        suitableCard = Helper.findSuitableCard(friendsPage, targetFriendName);
        assertNotNull(suitableCard);
        suitableCard.showBar(driver);
        WebElement bar = driver.findElement(By.className("gwt-shortcutMenu-content"));
        assertNotNull(bar);
        WebElement raw = bar.findElement(By.xpath(suitableRaw));
        raw.click();
        assertNotNull(driver.findElement(By.xpath(".//*[@class='modal-new_center']")));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("rel_type_cb_15")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.name("button_save_rlshp"))).build().perform();
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
