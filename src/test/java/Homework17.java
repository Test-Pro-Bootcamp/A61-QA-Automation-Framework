import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist(){

    //Logging into Koel
        navigateToWebsite("https://qa.koel.app/");
        inputEmail("barrau89@gmail.com");
        inputPassword("te$t$tudent");
        clickLoginButton();

    //Search for a song
        clickAllSongs();
        selectASong();

        
    }

    private void clickAllSongs() {
        WebElement allSongs = driver.findElement(By.cssSelector("a[class='songs']"));
        allSongs.click();
    }

    private void selectASong() {
        WebElement findASong = driver.findElement(By.cssSelector("table.items tr.song-item:first-of-type"));
        findASong.click();
        clickAddToButton();
    }

    private void clickAddToButton() {
        WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToButton.click();
        selectPlaylist();
    }

    private void selectPlaylist(){
        WebElement playlist = driver.findElement(By.cssSelector("section.existing-playlists > ul > li.playlist"));
        playlist.click();
        verifyPopUpAppeared();
    }

    private void verifyPopUpAppeared(){
        WebElement greenBoxPopUp = driver.findElement(By.cssSelector("div.success.show"));
        String popUpLabel = greenBoxPopUp.getText();
        Assert.assertTrue(popUpLabel.contains("Added 1 song into"), "Pop-up does not contain the expected substring.");
    }
}
