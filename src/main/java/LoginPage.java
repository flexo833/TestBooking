import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.xpath("//input[@id='username']");
    private By submitButton = By.xpath("//span[@class='bui-button__text']");
    private By passwordField = By.xpath("//input[@id='password']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void signIn(String email, String password)  {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(submitButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }


}
