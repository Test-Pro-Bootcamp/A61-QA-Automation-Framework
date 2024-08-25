import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    public String currentPlaylistName = "countSongsPlaylist";
    public String newPlaylistName = "newPlaylistName";

    @Test (dataProvider = "LoginWithPositiveData")
    public void renamePlaylist(String email, String password){

        //login
        loginIntoKoel(email, password);

        //select playlist to rename
        //findPlaylistToRename(currentPlaylistName);

        //right click on playlist
        contextClickPlaylist(currentPlaylistName);

        //select 'Edit' (first option on context menu)
        selectEditPlaylist();

        //rename Playlist
        renamePlaylist(newPlaylistName);

    }


    private void findPlaylistToRename(String playlistName) {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("a[contains(text(),'"+playlistName+"')]")));
        playlist.click();
    }

    private void contextClickPlaylist(String playlistName) {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("a[contains(text(),'"+playlistName+"')]")));
        actions.contextClick(playlist).perform();
    }
    private void selectEditPlaylist(){
        WebElement editPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]/nav/ul/li[1]")));
        editPlaylist.click();
    }
    private void renamePlaylist(String newPlaylistName){
        WebElement playlistNameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name'][data-testid='inline-playlist-name-input']")));
        playlistNameInputField.clear();
        playlistNameInputField.sendKeys(newPlaylistName);
    }


}
