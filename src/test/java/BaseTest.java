import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.Current;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

  public class BaseTest {

    public WebDriver driver;
    WebDriverWait wait = null;
    /* public String url="https://qa.koel.app/"; */
   /* @DataProvider(name="LoginNegativeTestData")
        public Object[][] getDataFromDataProvider(){
        return new Object[][]  {
                {"invalidEmail@gmail.com", "invalid"},
                {"demo@gmail.com", "     "},
                {"        ", "   "},
                {"          ", " Veena@123  "},
        };
        }*/
        @BeforeSuite
        static void setupClass() {
        WebDriverManager.chromedriver().setup();
      }
      @BeforeMethod
     @Parameters({"BaseURL"})
      public void launchBrowser(String baseURL){
        // add chromeArguments
        String url= baseURL;
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        navigateToPage(url);
      }
      @AfterMethod
      public void closeBrowser(){
        driver.quit();
      }
      public void navigateToPage(String url){
        driver.get(url);
      }
      public void provideEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("input[type='email']")));
                // driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
       }
       public void providePassword(String password) {
           WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated
                   (By.cssSelector("input[type='password']")));
           passwordField.clear();
           passwordField.sendKeys(password);
       }

           protected void loginBtn() {

               WebElement loginButton= driver.findElement(By.cssSelector("button[type='submit']"));
          /* WebElement   loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                       (By.cssSelector("input[type='submit']")));*/
               loginButton.click();
          }
      }