import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest{

    @Test
    public void registrationNavigation(){

        // Using Selenium, navigate to "https://qa.koel.app/"
        url = "https://qa.koel.app/";
        driver.get(url);

        // Click the registration link
        WebElement registrationButton = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationButton.click();

        // Verify being redirected to Registration page
        WebElement registrationText = driver.findElement(By.cssSelector("span[class='small']"));
        Assert.assertTrue(registrationText.isDisplayed());


    }
}
