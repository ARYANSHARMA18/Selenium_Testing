import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity18 {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/selects");

        WebElement multi_select = driver.findElement(By.id("multi-select"));

        Select list = new Select(multi_select);

        list.selectByVisibleText("Javascript");
        list.selectByIndex(4);
        list.selectByIndex(5);
        list.selectByIndex(6);

        list.selectByValue("node");
        list.deselectByIndex(5);

        driver.quit();

    }
}


