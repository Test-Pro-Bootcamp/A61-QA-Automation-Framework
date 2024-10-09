package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class LoginstepDefination {
    WebDriver driver;
    WebDriverWait wait;

    //@Given("I open the Browser")
    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disabled-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

    @And("I open the Login Page")
    public void iOpenTheLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    @When("I Enter the Email {string}")
    public void iEnterTheEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @And("I Enter the Password {string}")
    public void iEnterThePassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @And("I click the Submit")
    public void iClickTheSubmit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
    }

    @Then("I Logged in to the Application")
    public void iLoggedInToTheApplication() {
        Assert.assertTrue( wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[img.avatar]"))).isDisplayed());
    }

    @Then("I should not get  Logged in to the Application")
    public void iShouldNotGetLoggedInToTheApplication() {
        String expectedUrl="https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }


}
