import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongs extends BaseTest{
    @Test
    public void PlaySongTest()throws InterruptedException{
        provideEmail("Shuban.laddu@gmail.com");
        providePassword("Pavani@10");
        loginBtn();
        Thread.sleep(2000);
        clickPlay();
        Assert.assertTrue(isSongPlaying());

    }
    public void clickPlay() throws InterruptedException {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextButton.click();
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playBtn.click();
        Thread.sleep(3000);
    }
    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
}
