import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework16 extends BaseTest{

    @Test
    public void registrationNavigation(){

        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Using Selenium, navigate to "https://qa.koel.app/"
        String website = "https://qa.koel.app/";
        driver.get(website);

        // Click the registration link
        WebElement registrationButton = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationButton.click();

        // Verify being redirected to Registration page
        WebElement registrationText = driver.findElement(By.cssSelector("span[class='small']"));
        Assert.assertTrue(registrationText.isDisplayed());




    }
}
