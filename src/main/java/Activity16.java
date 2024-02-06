import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        WebElement username = driver.findElement(By.xpath("//input[starts-with(@class,'username-')]"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.xpath("//input[starts-with(@class,'password-')]"));
        password.sendKeys("password");

        WebElement btn = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button"));
        btn.click();

        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(message);

        driver.close();
    }
}


