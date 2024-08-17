import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest {

    @Test (dataProvider = "LoginWithPositiveData" )
    public void playSong(String email, String password){
        //////login
        inputEmail(email);
        inputPassword(password);
        clickLoginButton();
        //////move to All Songs section
        chooseAllSongsList();
        //////right-click on the first song
        contextClickFirstSong();
        //////select first option of the right-click menu
        choosePlayOption();
        //////validate if song is playing
        Assert.assertTrue(isSongPlaying());

    }

    public void choosePlayOption() {
        WebElement playOptionFromContextMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback")));
        playOptionFromContextMenu.click();

    }

    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }

    public void chooseAllSongsList() {
        WebElement allSongsTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs")));
        allSongsTab.click();
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////



}
