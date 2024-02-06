import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestActivity7 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "Authentication")
    public static Object[] credentials(){
        return new Object[][]{
                {"admin","password"},
                {"admin1","password"}
        }  ;
    }

    @Test(dataProvider = "Authentication")
    public void exampleTestCase(String username,String password){
        WebElement usr =driver.findElement(By.id("username"));
        usr.sendKeys(username);
        WebElement pass =driver.findElement(By.id("password"));
        pass.sendKeys(password);

        driver.findElement(By.xpath("//button[@class='ui button']")).click();
        usr.clear();
        pass.clear();
    }

    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}
