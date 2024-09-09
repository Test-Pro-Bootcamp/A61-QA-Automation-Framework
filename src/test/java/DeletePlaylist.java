import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlaylist extends BaseTest{
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
        WebElement PlaylistName = driver.findElement(By.cssSelector("li.playlist:nth-child(3)"));
        PlaylistName.click();
        Thread.sleep(2000);
    }
    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement DeletePlaylistBtn = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        DeletePlaylistBtn.click();
        Thread.sleep(2000);
    }
    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }
}
