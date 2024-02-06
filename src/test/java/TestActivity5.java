import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestActivity5 {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test(groups = {"HeaderTests"})
    public void HeaderTestCase1() {
        WebElement th_header = driver.findElement(By.id("third-header"));
        Assert.assertEquals(th_header.getText(), "Third header");
    }

    @Test(groups = {"HeaderTests"})
    public void HeaderTestCase2() {
        WebElement fi_header = driver.findElement(By.tagName("h5"));
        Assert.assertEquals(fi_header.getCssValue("color"), "rgb(33, 186, 69)");
    }

    @Test(groups = {"ButtonTests"})
    public void ButtonTestCase1() {
        WebElement olive_btn = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(olive_btn.getText(), "Olive");
    }

    @Test(groups = {"ButtonTests"})
    public void ButtonTestCase2() {
        WebElement brown_btn = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(brown_btn.getCssValue("color"), "rgb(255, 255, 255)");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }
}
