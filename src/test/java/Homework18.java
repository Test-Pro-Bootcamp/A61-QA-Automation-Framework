import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void addSongToPlaylist() {

        //Logging into Koel
        navigateToWebsite("https://qa.koel.app/");
        inputEmail("barrau89@gmail.com");
        inputPassword("te$t$tudent");
        clickLoginButton();

        //Hover over web media
        hoverOverMediaPlayer();

        //Play a song
        clickMediaPlayButton();

        //Validate song is playing
        validateSongIsPlaying();

    }

    private void hoverOverMediaPlayer() {
        WebElement mediaElement = driver.findElement(By.cssSelector("span[class='play']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mediaElement).perform();
    }

    private void clickMediaPlayButton() {
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='play']")));
        playButton.click();
    }

    private void validateSongIsPlaying() {
        WebElement soundBars = driver.findElement(By.cssSelector("div[class='bars']"));
        Assert.assertTrue(soundBars.isEnabled());
    }
}
