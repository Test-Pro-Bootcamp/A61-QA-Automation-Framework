import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        //Play a song
        clickMediaPlayButton();
        validateSongIsPlaying();

    }

    private void clickMediaPlayButton() {
        WebElement playButton = driver.findElement(By.cssSelector("span[class='play']"));
        playButton.click();
    }

    private void validateSongIsPlaying() {
        WebElement soundBars = driver.findElement(By.cssSelector("div[class='bars']"));
        Assert.assertTrue(soundBars.isEnabled());
    }
}
