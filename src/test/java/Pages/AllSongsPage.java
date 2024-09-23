package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

 public class AllSongsPage extends BasePage{

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void clickPlayBtn() {
        WebElement PlayBtn =wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li.playback")));
        PlayBtn.click();
    }

}
