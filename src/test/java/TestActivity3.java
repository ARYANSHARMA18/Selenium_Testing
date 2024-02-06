import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity3 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    public void exampleTestCase(){
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        driver.findElement(By.xpath("//button[@class='ui button']")).click();

        WebElement cfm_msg = driver.findElement(By.id("action-confirmation"));
        Assert.assertEquals(cfm_msg.getText(), "Welcome Back, admin");

    }

    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}
