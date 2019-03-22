package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupsPage extends BasePage {

    private WebDriver driver;

    public GroupsPage(WebDriver driver) {
        this.driver = driver;
        check(driver);
    }

    public void count() {
        int countA = 0, countB = 0, countAnother = 0;

        List<WebElement> webElementList = driver.findElements(By.id(""));
       /* for (WebElement element : webElementList) {
            if (element.getText().endsWith("a")) {
                countA++;
            } else if (element.getText().endsWith("b")){
                countB++;
            } else {
                countAnother++;
            }
        }*/
        int index = 0;
        while (index < webElementList.size()) {
            String string = webElementList.get(index).getText();
            switch (string.substring(string.length() - 1)) {
                case "a":
                    countA++;
                    break;
                case "b":
                    countB++;
                    break;
                default:
                    countAnother++;
            }
            index++;
            if (index > 100000) {
                break;
            }
        }
    }

    @Override
    boolean check(WebDriver driver) {
        return false;
    }
}
