import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.Current;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

  public class BaseTest {

      public static WebDriver driver;
      WebDriverWait wait = null;
      Actions action;

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
          // WebDriverManager.firefoxdriver().setup();
      }

      @BeforeMethod
      @Parameters({"BaseURL"})
      public void launchBrowser(String baseURL) throws MalformedURLException {
          // add chromeArguments
          String url = baseURL;
          ChromeOptions options = new ChromeOptions();
          // options.addArguments("--remote-allow-origins=*");
          // driver = new ChromeDriver(options);
          // driver = new FirefoxDriver();
          driver = pickBrowser(System.getProperty("browser"));
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.manage().window().maximize();
          wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         /* fluentWait = new FluentWait(driver)
                  .withTimeout(Duration.ofSeconds(10))
                  .pollingEvery(Duration.ofSeconds(2));*/
          action = new Actions(driver);
          navigateToPage(url);

      }

      @AfterMethod
      public void closeBrowser() {
          driver.quit();
      }

      public void navigateToPage(String url) {
          driver.get(url);
      }

      public void provideEmail(String email) {
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

      public void loginBtn() {

          WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
          /* WebElement   loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                       (By.cssSelector("input[type='submit']")));*/
          loginButton.click();
      }

      public WebElement isSongPlayingBars() {
          WebElement SoundBars = wait.until(ExpectedConditions.visibilityOfElementLocated
                  (By.cssSelector("img[alt='Sound bars']")));
          return SoundBars;
      }

      //example of selenium Grid
      public static WebDriver pickBrowser(String browser) throws MalformedURLException {
          DesiredCapabilities caps = new DesiredCapabilities();
          String gridUrl = "http://10.0.0.206:4444/";

          switch (browser) {
              case "firefox":
                  // WebDriverManager.firefoxdriver().setup();
                  // return driver= new FirefoxDriver();
                  WebDriverManager.firefoxdriver().setup();
                  return driver = new FirefoxDriver();
              case "MicrosoftEdge":
                  WebDriverManager.edgedriver().setup();
                  EdgeOptions edgeOptions = new EdgeOptions();
                  edgeOptions.addArguments("--remote-allow-origins=*");
                  return driver = new EdgeDriver(edgeOptions);
                  //Grid related Browsers
              case "grid-edge":
                  caps.setCapability("browserName","MicrosoftEdge");
                  return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
              case "grid-firefox":
                  caps.setCapability("browserName", "firefox");
                  return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
              case "grid-chrome":
                  caps.setCapability("browserName","chrome");
                  return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
              default:
                  WebDriverManager.chromedriver().setup();
                  ChromeOptions chromeOptions = new ChromeOptions();
                  chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
          }


      }
  }
