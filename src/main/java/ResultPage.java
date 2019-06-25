import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ResultPage {
    private WebDriver driver;
    private By sortBarButton = By.xpath("//li[@class=' sort_category   sort_price ']");


    public ResultPage(WebDriver driver) {
        this.driver = driver;

    }

    public void sortByPrice() throws NullPointerException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(sortBarButton));
        driver.findElement(sortBarButton).click();

    }

    public boolean verifyPrice() {
        List<Integer> price = new ArrayList<Integer>();
        List<Integer> expected = new ArrayList<Integer>();
        List<String> atributes = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='bui-price-display__value prco-inline-block-maker-helper ']"));
        for (int i = 0; i < elements.size(); i++) {
            atributes.add(elements.get(i).getAttribute("innerText"));
        }

        for (int i = 0; i < atributes.size(); i++) {
            price.add(Integer.parseInt(String.valueOf(Integer.parseInt(atributes.get(i).replaceAll("[\\D]", "")))));
        }
        for (int i = 0; i < price.size(); i++) {
            System.out.println(price.get(i));
        }

        for (int i = 0; i < price.size(); i++) {
            expected.add(price.get(i));
        }
        Collections.sort(expected);

        if (price.contains(expected.toArray())) {
            return true;
        }
        return false;
    }
}
