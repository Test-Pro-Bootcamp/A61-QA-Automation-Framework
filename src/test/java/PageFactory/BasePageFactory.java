package PageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageFactory {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePageFactory(WebDriver givenDriver) {
        this.driver = givenDriver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.actions = new Actions(this.driver);
        PageFactory.initElements(driver, this);

    }

    public WebElement isSongPlayingBars() {
            WebElement SoundBars= wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector("img[alt='Sound bars']")));
            return SoundBars;
        }

    }
