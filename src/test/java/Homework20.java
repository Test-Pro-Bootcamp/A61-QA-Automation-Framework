import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    WebDriverWait wait;
    @Test
    public void DeletePlaylistTest()throws InterruptedException{
        String expectedPlaylistDeletedMsg = "Deleted playlist \"veena.\"";

        provideEmail("Shuban.laddu@gmail.com");
        providePassword("Pavani@10");
        loginBtn();
        Thread.sleep(3000);
        OpenSelectedPlaylist();
        clickDeletePlaylistBtn();
        byte[] expectedPlaylistDeletedMessage;
        Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlaylistDeletedMsg);
    }
    public void OpenSelectedPlaylist() throws InterruptedException {
        //WebElement PlaylistName = driver.findElement(By.cssSelector("li.playlist:nth-child(3)"));
        WebElement PlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li.playlist:nth-child(3)")));
        PlaylistName.click();
        /* Thread.sleep(2000); */
    }
    public void clickDeletePlaylistBtn() throws InterruptedException{
       // WebElement DeletePlaylistBtn = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        WebElement DeletedPlaylistBtn= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("button[class='del btn-delete-playlist']")));
        DeletedPlaylistBtn.click();
        //Thread.sleep(2000);
    }
    public String getDeletedPlaylistMsg()throws InterruptedException{
       // WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
}


