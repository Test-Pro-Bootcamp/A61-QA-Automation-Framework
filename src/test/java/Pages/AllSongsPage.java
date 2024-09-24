package Pages;//package Pages;

import PageFactory.AllSongsPageFactory;
import PageFactory.BasePageFactory;
import PageFactory.LoginPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AllSongsPage extends BasePageFactory {


    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public void PlaySongswithcontextclickPage() {
       LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
       AllSongsPageFactory allSongsPageFactory = new AllSongsPageFactory(driver);

       loginPageFactory.provideEmail("Shuban.laddu@gmail.com");
       loginPageFactory.providePassword("Pavani@10");
       loginPageFactory.loginBtn();

    }


}
