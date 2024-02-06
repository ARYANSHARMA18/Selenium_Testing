import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity23 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.amazon.in/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone 15");

        driver.findElement(By.id("nav-search-submit-button")).click();

        List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        WebElement thirdPrice = priceList.get(2);
        System.out.println("Third Price: " + thirdPrice.getText());

        driver.quit();
    }
}
