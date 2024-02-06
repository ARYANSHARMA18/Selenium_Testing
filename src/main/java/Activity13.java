import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/tables");


        //print number of cols
        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td")) ;

        System.out.println(cols.size());

        //Print number of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr")) ;

        System.out.println(rows.size());

        //Third Row
        List<WebElement> third_rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));

        for(WebElement cell : third_rows){
            System.out.println(cell.getText());
        }

//Second Row Second Column
        WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]"));

        System.out.println(cellValue.getText());


        driver.close();

    }
}


