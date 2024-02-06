import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the website
        driver.get("https://v1.training-support.net/selenium/input-events");

        // Get the title of the page and print it to the console
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        // Find the cube element on the page
        WebElement cube = driver.findElement(By.id("wrapD3Cube"));

        // Perform a left click on the cube and print the value of the side in the front
        Actions actions = new Actions(driver);
        actions.click(cube).build().perform();
        WebElement frontSide = driver.findElement(By.className("active"));
        System.out.println("The value of the side in the front is: " + frontSide.getText());

        // Perform a double click on the cube and print the number of the random side
        actions.doubleClick(cube).build().perform();
        WebElement randomSide = driver.findElement(By.className("active"));
        System.out.println("The number of the random side is: " + randomSide.getText());

        // Perform a right click on the cube and print the value shown on the front of the cube
        actions.contextClick(cube).build().perform();
        WebElement frontValue = driver.findElement(By.xpath("//div[@class='active']/following-sibling::div[1]"));
        System.out.println("The value shown on the front of the cube is: " + frontValue.getText());

        // Close the browser
        driver.close();
    }
}