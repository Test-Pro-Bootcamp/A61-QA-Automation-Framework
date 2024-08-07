import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test (dataProvider = "LoginWithPositiveData")
    public void deletePlaylist(String possitiveEmail, String possitivePassword) {

        //Logging into Koel
        inputEmail(possitiveEmail);
        inputPassword(possitivePassword);
        clickLoginButton();

        //Validate playlist was deleted
        validatePlaylistWasDeleted();

    }


    private void validatePlaylistWasDeleted() {
        WebElement playlistToDelete = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3)"));
        playlistToDelete.click();
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        deletePlaylistButton.click();

        verifyPopUpAppeared();
    }

    private void verifyPopUpAppeared(){
        WebElement greenBoxPopUp = driver.findElement(By.cssSelector("div[class='success show']"));
        String popUpLabel = greenBoxPopUp.getText();
        Assert.assertTrue(popUpLabel.contains("Deleted playlist"), "Pop-up does not contain the expected substring.");
    }
}
 // button.del.btn-delete-playlist