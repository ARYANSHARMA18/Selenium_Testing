import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12 {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        WebElement txt_box = driver.findElement(By.id("input-text"));

        System.out.println(txt_box.isEnabled());

        WebElement btn = driver.findElement(By.id("toggleInput"));

        btn.click();

        System.out.println(txt_box.isEnabled());

        driver.quit();

    }
}


