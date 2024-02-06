import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17{
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/selects");

        WebElement slct = driver.findElement(By.id("single-select"));

        Select list = new Select(slct);

        list.selectByVisibleText("Option 2");
        list.selectByIndex(3);
        list.selectByValue("4");

        List<WebElement> options = list.getOptions();

        for(WebElement option : options){
            System.out.println(option.getText());
        }

        driver.quit();

    }
}


