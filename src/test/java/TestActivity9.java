import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity9 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        driver.switchTo().defaultContent();
    }

    @Test
    public void TestCase1(){
        driver.findElement(By.id("simple")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void TestCase2(){
        driver.findElement(By.id("confirm")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void TestCase3(){
        driver.findElement(By.id("prompt")).click();
        System.out.println(driver.switchTo().alert().getText());
    }

    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}
