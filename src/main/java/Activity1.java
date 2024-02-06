import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;

public class Activity1 {
        public static void main(String[] args) {
            WebDriverManager.firefoxdriver().setup();

            WebDriver driver = new FirefoxDriver();

            driver.get("https://v1.training-support.net");

            String title = driver.getTitle();

            System.out.println(title);

            String buttonId = "about-link";

            WebElement button = driver.findElement(By.id(buttonId));

            button.click();

            String aboutTitle = driver.getTitle();

            System.out.println(aboutTitle);


            driver.quit();
        }
    }
