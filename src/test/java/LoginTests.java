import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        navigateToWebsite("https://qa.koel.app/");
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginWithEmailAndPassword() {

        // Step 1
        navigateToWebsite("https://qa.koel.app/");

        // Step 2
        inputEmail("barrau89@gmail.com");

        // Step 3
        inputPassword("te$t$tudent");

        // Step 4
        clickLoginButton();
    }

    public void navigateToWebsite(String url){
        driver.get(url);
    }

    public void inputEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }


}
