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
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

      public static WebDriver driver;
     // public ChromeOptions options = new ChromeOptions();
      public  WebDriverWait wait = null;
      public Actions action =null;

      private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

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
      public void setBrowser(String baseURL) throws MalformedURLException {
          threadDriver.set(pickBrowser(System.getProperty("browser")));
          getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          getDriver().manage().window().maximize();
          navigateToPage(baseURL);
      }

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
          //navigateToPage(url);

      }
      public WebDriver lambdaTest() throws MalformedURLException{
          String hubUrl = "https://hub.lambdatest.com/wd/hub";
          ChromeOptions browserOptions = new ChromeOptions();
          browserOptions.setPlatformName("Windows 10");
          browserOptions.setBrowserVersion("128");
          HashMap<String, Object> ltOptions = new HashMap<String, Object>();
          ltOptions.put("username", "praveenag1602");
          ltOptions.put("accessKey", "waFjvbgGzC6hmDn3nxmkv0c78TwLfSVWXZzTjJttlAecS3Cti4");
          ltOptions.put("project", "Untitled");
          ltOptions.put("selenium_version", "4.0.0");
          ltOptions.put("w3c", true);
          browserOptions.setCapability("LT:Options", ltOptions);
          return new RemoteWebDriver(new URL(hubUrl),browserOptions);
      }

      @AfterMethod
      public void tearDown(){
          threadDriver.get().close();
          threadDriver.remove();
      }

      public void closeBrowser() {
          driver.quit();
      }

      public void navigateToPage(String url) {
          getDriver().get(url);
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
      public static WebDriver getDriver(){
          return threadDriver.get();
      }

      //example of selenium Grid
      public WebDriver pickBrowser(String browser) throws MalformedURLException {
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
              case "cloud":
                  return lambdaTest();
              default:
                  WebDriverManager.chromedriver().setup();
                  ChromeOptions chromeOptions = new ChromeOptions();
                  chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
          }


      }
  }
