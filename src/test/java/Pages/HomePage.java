package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public  void chooseFirstSongFromList() {
        WebElement FirstSongFromList = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"songsWrapper\"]//table/tr[1]/td[1]\n")));
        FirstSongFromList.click();
        actions.contextClick(FirstSongFromList).perform();
    }

}
