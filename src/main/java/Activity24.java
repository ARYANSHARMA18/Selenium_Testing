import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class Activity24 {
    public static void main(String[] args){

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);
        WebDriver driver = new FirefoxDriver(firefoxOptions);

        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("iphone 15");
        driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();

        List<WebElement> list_title = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
        System.out.println(list_title.get(2).getText());

        List<WebElement> list_price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
        System.out.println(list_price.get(2).getText());


        driver.close();

    }
}


