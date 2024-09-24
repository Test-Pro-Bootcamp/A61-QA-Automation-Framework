package PageFactory;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPageFactory extends BasePage {
    public LoginPageFactory (WebDriver  givendriver){
        super(givendriver);
    }
//PageFactory Elements
    @FindBy (css="[type='submit']")
    WebElement loginBtn;

    @FindBy (css="[type='email']")
    WebElement EmailField;

    @FindBy (css="[type='password']")
    WebElement PasswordField;
    //Helper Methods
    public LoginPageFactory provideEmail(String email){
        EmailField.sendKeys(email);
        return this;
    }
    public LoginPageFactory providePassword(String password){
        PasswordField.sendKeys(password);
        return this;
    }
    public LoginPageFactory loginBtn(){
        loginBtn.click();
        return this;
    }

}
