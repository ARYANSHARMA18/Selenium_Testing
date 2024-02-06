import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity2 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void exampleTestCase(){
        String title= driver.getTitle();

        Assert.assertEquals(title,"Target Practice");

    }

    @Test
    public void exampleTestCase2(){
        WebElement btn = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(btn.isDisplayed(),"Black btn is not visible");
        Assert.assertEquals(btn.getText(),"black");
    }

    @Test(enabled = false)
    public void exampleTestCase3(){

    }

    @Test
    public void exampleTestCase4(){
        throw new SkipException("Skipping intentionally!!");
    }

    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}
