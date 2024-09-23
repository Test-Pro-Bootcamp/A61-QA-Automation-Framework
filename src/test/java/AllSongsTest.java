import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest{
    @Test
    public void PlaySongswithcontextclick() throws InterruptedException {
        LoginPage loginPage =new LoginPage(driver);
        HomePage   homePage = new HomePage(driver);
        AllSongsPage allSongsPage= new AllSongsPage(driver);
        loginPage.login();

        //login
        /*provideEmail("Shuban.laddu@gmail.com");
        providePassword("Pavani@10");
        loginBtn();*/
        //click All songs

       homePage.clickAllSongsList();
        Thread.sleep(2000);
        //chooseFirstSong
        homePage.chooseFirstSongFromList();
        Thread.sleep(2000);
        //contextclick
        //click on play button
       allSongsPage.clickPlayBtn();
        Thread.sleep(2000);
        //verifying the song playing
        Assert.assertTrue(allSongsPage.isSongPlayingBars());
    }
}








