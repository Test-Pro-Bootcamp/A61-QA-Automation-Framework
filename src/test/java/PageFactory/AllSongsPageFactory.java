package PageFactory;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPageFactory extends BasePageFactory {


    public AllSongsPageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }
    //WebElements
    @FindBy (css="li a.songs")
    WebElement AllSongslist;

    @FindBy (xpath="//*[@id=\"songsWrapper\"]//table/tr[1]/td[1]\n")
    WebElement FirstSongFromList;

    @FindBy (css="li.playback")
    WebElement PlayBtn;

    @FindBy (css="img[alt='Sound bars']")
    WebElement SoundBars;
    //Methods

    public AllSongsPageFactory clickAllSongsPageFactory(){
        AllSongslist.click();
        return this;
    }
    public AllSongsPageFactory chooseFirstSongFromListPageFactory(){
        FirstSongFromList.click();
        actions.contextClick(FirstSongFromList).perform();
        return this;
    }
    public AllSongsPageFactory clickPlayBtnPageFactory(){
        PlayBtn.click();
        return this;
    }
    public WebElement isSongPlayingBarsPageFactory(){
      return wait.until(ExpectedConditions.visibilityOf(SoundBars));
    }

}
