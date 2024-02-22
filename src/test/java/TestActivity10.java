import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestActivity10 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();https://v1.training-support.net/selenium/simple-form
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("");
    }

    public static List<List<Object>> readExcel(String filePath) {
        List<List<Object>> data = new ArrayList<>();
        try {
            // Read the file as a stream
            FileInputStream file = new FileInputStream(filePath);

            // Create the workbook
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first sheet from that workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through all the rows one by one
            for (Row row: sheet) {
                // Temp var
                List<Object> rowData = new ArrayList<>();
                // Iterate over all the cells one by one
                for(Cell cell: row) {
                    if(cell != null) {
                        switch (cell.getCellType()) {
                            case STRING -> rowData.add(cell.getStringCellValue());
                            case NUMERIC -> rowData.add(cell.getNumericCellValue());
                            case BOOLEAN -> rowData.add(cell.getBooleanCellValue());
                        }
                    }
                }
                data.add(rowData);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "Registration")
    public static Object[][] signUpInfo() {
        String filePath = "C:\\Users\\AryanSharma\\IdeaProjects\\IBM_Selenium_Testing\\src\\test\\java\\Activity10.xlsx";
        List<List<Object>> data = readExcel(filePath);
        return new Object[][] {
                { data.get(1) },
                { data.get(2) },
                { data.get(3) },
        };
    }

    @Test(dataProvider = "Registration")
    public void registrationTest(List<Object> rows) throws IOException, AWTException {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement phoneNumberField = driver.findElement(By.id("number"));

        // Clear the fields
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneNumberField.clear();

        // Enter the data
        firstNameField.sendKeys(rows.get(1).toString());
        lastNameField.sendKeys(rows.get(2).toString());
        emailField.sendKeys(rows.get(3).toString());
        phoneNumberField.sendKeys(rows.get(4).toString());

        String fileName = System.currentTimeMillis() + "Test";
        File screenshot =((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        File outputFile = new File("LoggerScreenshots/" + fileName +".png");
        System.out.println(outputFile.getAbsolutePath());

        try{
            FileUtils.copyFile(screenshot,outputFile);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        // Click on the submit button
        driver.findElement(By.cssSelector("input.green")).click();

        // Wait for the alert to show up
        wait.until(ExpectedConditions.alertIsPresent());

        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        String fileName_2 = System.currentTimeMillis() + "_Alert";
        ImageIO.write(image, "png", new File("LoggerScreenshots/"+ fileName_2 +".png"));


        // Switch to Alert
        Alert message = driver.switchTo().alert();

        // Get the alert message
        System.out.println("Alert Message: " + message.getText());
        Reporter.log("Alert Message: " + message.getText());

        message.accept();

        String fileName_3 = System.currentTimeMillis() + "Test";
        File screenshot_3 =((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        File outputFile_3 = new File("LoggerScreenshots/" + fileName_3 +".png");
        System.out.println(outputFile_3.getAbsolutePath());

        try{
            FileUtils.copyFile(screenshot_3,outputFile_3);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        // Refresh the page
        driver.navigate().refresh();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
