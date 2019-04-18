package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserMainPage extends BasePage {
    private static final String FRIENDS = "$x(\".//input[@id='field_email']\")";
    private static final String TOOLBAR = "$x(\"//*[@data-l='t,navigationToolbar']\")";
    private static final String AVATAR = "$x(\"//*[@class='entity-avatar']\")";
    private WebDriver driver;

    public UserMainPage(WebDriver driver) {
        this.driver = driver;
        if (!check(driver)) {
            throw new IllegalArgumentException();
        }
    }

    public void click(WebElement field) {
        field.click();
    }

    public WebElement getFriendsField() {
        return driver.findElement(By.xpath(FRIENDS));
    }

    public WebElement getToolbarField() {
        return driver.findElement(By.xpath(TOOLBAR));
    }

    public WebElement getAvatarField() {
        return driver.findElement(By.xpath(AVATAR));
    }

    @Override
    boolean check(WebDriver driver) {
        return getFriendsField() != null
            && getToolbarField() != null
            && getAvatarField() != null;
    }
}
