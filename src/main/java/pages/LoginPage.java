package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private static final String LOGIN_FIELD = ".//input[@id='field_email']";
    private static final String PASSWORD_FIELD = ".//input[@id='field_password']";
    private static final String SUBMIT = "//form//div[@class='form-actions']//input[@type='submit']";
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!check(driver)) {
            throw new IllegalArgumentException();
        }
    }

    public void clearField(WebElement field) {
        field.clear();
    }

    public void sendKeys(WebElement field, String text) {
        field.sendKeys(text);
    }

    public void clickSubmit(WebElement submit) {
        submit.click();
    }

    public WebElement getLoginField() {
        return driver.findElement(By.xpath(LOGIN_FIELD));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.xpath(PASSWORD_FIELD));
    }

    public WebElement getSubmitField() {
        return driver.findElement(By.xpath(SUBMIT));
    }

    @Override
    boolean check(WebDriver driver) {
        return getLoginField() != null
            && getPasswordField() != null
            && getSubmitField() != null;
    }
}
