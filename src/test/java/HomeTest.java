import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{

    @Test (dataProvider = "LoginWithPositiveData")
    public void hoverOverPlayButton(String email, String password){

        ///login
        loginIntoKoel(email, password);
        ///verify Play Song button is visible with mouse hover
        Assert.assertTrue(hoverPlayButton().isDisplayed());
    }

    @Test (dataProvider = "LoginWithPositiveData")
    public void countSongsInPlaylist(String email, String password){
        loginIntoKoel(email,password);
        choosePlaylist("countSongsPlaylist");
        //displayAllSongs after looping into the playlist
        displayAllSongs();
        //Assertion - contains the # of songs as mentioned in the header
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    public void choosePlaylist(String playlistName){
        // if searched by name
        // xPath: a[contains(text(),'student')] ul li.playlist:nth-child("+playlistNumber+")"
        /*
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("a[contains(text(),'"+playlistName+"')]")));
        playlist.click();
        */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("a[contains(text(),'"+playlistName+"')]"))).click();

    }

    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public void displayAllSongs(){
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found: "+ countSongs());
        for (WebElement e: songList ){
            System.out.println(e.getText());
        }
    }




}
