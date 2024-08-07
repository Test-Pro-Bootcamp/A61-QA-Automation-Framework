import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    @Parameters ({"BaseURL"})
    public void loginEmptyEmailPassword(String baseURL) {
        navigateToWebsite(baseURL);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
    }

    @Test (dataProvider = "LoginWithNegativeData")
    @Parameters ({"BaseURL"})
    public void loginWithNegativeData( String email, String password) throws InterruptedException {
        navigateToWebsite("https://qa.koel.app/");
        inputEmail(email);
        inputPassword(password);
        clickLoginButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }

    @Test
    @Parameters ({"BaseURL"})
    public void loginWithEmailAndPassword(String baseURL) {

        // Step 1
        navigateToWebsite(baseURL);
        // Step 2
        inputEmail("barrau89@gmail.com");
        // Step 3
        inputPassword("te$t$tudent");
        // Step 4
        clickLoginButton();
    }


}
