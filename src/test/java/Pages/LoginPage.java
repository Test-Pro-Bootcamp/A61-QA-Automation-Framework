package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Elements
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By loginButton = By.cssSelector("button[type='submit']");

//Helper Methods
    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void loginBtn(){
        findElement(loginButton).click();
    }
    public void login(){
        provideEmail("Shuban.laddu@gmail.com");
        providePassword("Pavani@10");
        loginBtn();

    }


}
