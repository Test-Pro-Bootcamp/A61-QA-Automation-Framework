import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test(enabled = true, priority = 0, description = " login Invalid Email Valid password")
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

    @Test(enabled = true, priority = 1, description = "login Valid Email Valid Password")
    public void loginValidEmailPassword() throws InterruptedException {
        provideEmail("Shuban.laddu@gmail.com");
        providePassword("Pavani@10");
        loginBtn();
        Thread.sleep(2000);
        String url = "https://qa.koel.app/";
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assertions Expected VS Actual
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test(enabled = true, priority = 2, description = "login Empty Email Empty Password")
    public void loginEmptyEmailEmptyPassword() throws InterruptedException {
        provideEmail("         ");
        providePassword("       ");
        loginBtn();
        Thread.sleep(2000);
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test(enabled = true, priority = 3, description = "login Valid Email Empty Password")
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
}
