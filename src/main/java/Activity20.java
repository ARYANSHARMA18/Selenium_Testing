import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
    public static void main(String[] args){

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        WebElement cfm_btn = driver.findElement(By.id("prompt"));
        cfm_btn.click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println(alertText);

        driver.switchTo().alert().sendKeys("Awesome");
        alert.accept();

        driver.quit();
    }
}


