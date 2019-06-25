import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("http://www.booking.com");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("testselenium_flexo@ukr.net", "Abcd12345");
        mainPage.selectOffers();

        ResultPage resultPage = new ResultPage(driver);
        resultPage.sortByPrice();
        Boolean result = resultPage.verifyPrice();
        System.out.println(result);
        driver.quit();


    }
}
