import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.Objects;

public class Activity7 {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/drag-drop");

        System.out.println(driver.getTitle());

        WebElement drop1 = driver.findElement(By.id("droppable"));
        WebElement drop2 = driver.findElement(By.id("dropzone2"));
        WebElement ball = driver.findElement(By.id("draggable"));

        Actions builder = new Actions(driver);



        builder.dragAndDrop(ball,drop1).build().perform();

        String drop1_txt = driver.findElement(By.xpath("//div[@id=\"droppable\"]/p")).getText();

        if(Objects.equals(drop1_txt, "Dropped!")){
            System.out.println("Verified Drop1");
        }

        builder.dragAndDrop(ball,drop2).build().perform();

        String drop2_txt = driver.findElement(By.xpath("//div[@id=\"dropzone2\"]/p")).getText();

        if(Objects.equals(drop2_txt, "Dropped!")){
            System.out.println("Verified Drop2");
        }

        driver.quit();

    }
}


