import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Activity21 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the page
        driver.get("https://v1.training-support.net/selenium/tab-opener");

        // Get the title of the page and print it to the console
        String pageTitle = driver.getTitle();
        System.out.println("Main Page Title: " + pageTitle);

        // Find the button to open a new tab and click it
        WebElement openTabButton = driver.findElement(By.id("launcher"));
        openTabButton.click();

        // Wait for the new tab to open
        waitForNewTab(driver);

        // Print all the handles
        Set<String> handles = driver.getWindowHandles();
        System.out.println("All Handles: " + handles);

        // Switch to the newly opened tab
        //switchToNewTab(driver);
        // Print the title and heading of the new tab
        System.out.println("New Tab Title: " + driver.getTitle());
        WebElement heading = driver.findElement(By.cssSelector("div.content h1"));
        System.out.println("New Tab Heading: " + heading.getText());

        // Repeat the steps by clicking the button in the new tab page
        WebElement openTabButtonInNewTab = driver.findElement(By.id("childtab"));
        openTabButtonInNewTab.click();

        // Wait for the new tab to open again
        waitForNewTab(driver);

        // Print all the handles again
        handles = driver.getWindowHandles();
        System.out.println("All Handles after opening tab in the new tab: " + handles);

        // Close the browser
        driver.quit();
    }

    private static void waitForNewTab(WebDriver driver) {
        // Wait for the new tab to open
        int numberOfHandles = driver.getWindowHandles().size();
        while (numberOfHandles == 1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numberOfHandles = driver.getWindowHandles().size();
        }
    }
    private static void switchToNewTab(WebDriver driver) {
        // Switch to the newly opened tab
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
        }
    }
}