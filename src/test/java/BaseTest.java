import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @DataProvider(name = "LoginWithNegativeData")
    public Object [][] getDataFromDataProvider(){
        return new Object[][]{
                {"invalidEmail@email.com","invalidPassword"},
                {"","te$t$tudent"}
        };
    }

    @DataProvider(name = "LoginWithPositiveData")
    public Object [][] positiveData(){
        return new Object[][]{
                {"barrau89@gmail.com","te$t$tudent"}
        };
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void launchBrowser(String baseURL) {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToWebsite(baseURL);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
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