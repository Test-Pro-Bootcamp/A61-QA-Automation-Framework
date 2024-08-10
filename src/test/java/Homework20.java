import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest {

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playlistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3)")));
        playlistToDelete.click();
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='del btn-delete-playlist']")));
        deletePlaylistButton.click();

        verifyPopUpAppeared();
    }



    private void verifyPopUpAppeared(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement greenBoxPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        String popUpLabel = greenBoxPopUp.getText();
        Assert.assertTrue(popUpLabel.contains("Deleted playlist"), "Pop-up does not contain the expected substring.");
    }
}
