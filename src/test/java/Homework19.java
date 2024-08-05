import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() {

        //Logging into Koel
        navigateToWebsite("https://qa.koel.app/");
        inputEmail("barrau89@gmail.com");
        inputPassword("te$t$tudent");
        clickLoginButton();



        //Validate playlist was deleted
        validatePlaylistWasDeleted();

    }


    private void validatePlaylistWasDeleted() {
        WebElement soundBars = driver.findElement(By.cssSelector("div[class='bars']"));
        Assert.assertTrue(soundBars.isEnabled());
    }
}
