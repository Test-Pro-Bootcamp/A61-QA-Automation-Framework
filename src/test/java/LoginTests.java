import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    String url = "https://qa.koel.app/";


    @Test
    public void loginEmptyEmailPassword() {
        navigateToWebsite(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginWithEmailAndPassword() {

        // Step 1
        navigateToWebsite(url);

        // Step 2
        inputEmail("barrau89@gmail.com");

        // Step 3
        inputPassword("te$t$tudent");

        // Step 4
        clickLoginButton();
    }


}
