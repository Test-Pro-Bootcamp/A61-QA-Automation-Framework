package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //page Elements
    By userAvatarIcon = By.cssSelector("img.avatar");
    //Helper Methods
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

}