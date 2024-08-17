import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{

    @Test (dataProvider = "LoginWithPositiveData")
    public void hoverOverPlayButton(String email, String password){

        ///login
        loginIntoKoel(email, password);
        ///verify Play Song button is visible with mouse hover
        Assert.assertTrue(hoverPlayButton().isDisplayed());
    }


}
