package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    WebDriverWait wait;

    Actions actions;

    //Constructor of the BasePage Class
    public  BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }
    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    /*public void clickAllSongsList() {
        WebElement AllSongslist= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li a.songs")));
        AllSongslist.click();
    }
    public boolean isSongPlayingBars() {
        WebElement SoundBar= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("img[alt='Sound bars']")));
        return SoundBar;
    }*/

}
