import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginInvalidEmailPassword() throws InterruptedException {
        provideEmail("Shuban1.laddu@gmail.com");
        providePassword("Pavani@10");
        loginBtn();
        Thread.sleep(2000);
        String url = "https://qa.koel.app/";
        // WebElement avatarIcon =driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assertions Expected VS Actual
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        provideEmail("Shuban.laddu@gmail.com");
        providePassword("Pavani@10");
        loginBtn();
        /* Thread.sleep(2000); */
        String url = "https://qa.koel.app/";
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon;
        avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("img[class='avatar']")));
        //Assertions Expected VS Actual
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginEmptyEmailEmptyPassword() throws InterruptedException {
        provideEmail("         ");
        providePassword("       ");
        loginBtn();
        Thread.sleep(2000);
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        provideEmail("Shuban.laddu@gmail.com");
        providePassword("        ");
        loginBtn();
        Thread.sleep(2000);
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    //loginNegativetest data
     @Test(dataProvider = "LoginNegativeTestData", enabled = false)
     public void loginNegativeTest(String Email, String Password) throws InterruptedException {
        provideEmail(Email);
        providePassword(Password);
        loginBtn();
        Thread.sleep(2000);
        String url = " https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void PositiveLoginTest(){
        //Objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Steps
        loginPage.provideEmail("Shuban.laddu@gmail.com");
        loginPage.providePassword("Pavani@10");
        loginPage.loginBtn();
        //Assertion E
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}
