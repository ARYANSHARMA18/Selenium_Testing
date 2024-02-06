import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
            WebDriverManager.firefoxdriver().setup();

            WebDriver driver = new FirefoxDriver();

            driver.get("https://v1.training-support.net/selenium/target-practice");

            System.out.println(driver.getTitle());

        WebElement third_header = driver.findElement(By.xpath("//h3[@id='third-header']"));
        System.out.println(third_header.getText());

        WebElement fifth_header = driver.findElement(By.xpath("//h5[@class='ui green header']"));
        System.out.println(fifth_header.getText());

        WebElement violet_btn = driver.findElement(By.xpath("//button[text()='Violet']"));
        System.out.println(violet_btn.getText());

        WebElement grey_btn = driver.findElement(By.xpath("//button[text()='Grey']"));
        System.out.println(grey_btn.getText());

        driver.quit();
        }
    }