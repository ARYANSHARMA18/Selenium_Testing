import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.edgedriver().setup();


        WebDriver driver = new FirefoxDriver();
//        WebDriver driver = new EdgeDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");

        System.out.print(driver.getTitle());

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        driver.quit();
    }
}

