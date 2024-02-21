package LG;

import org.testng.annotations.Test;
import java.sql.Driver;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestCases extends Parameter {
	
	WebDriver driver = new ChromeDriver();
	String URL= " https://leaders.jo/en/lg/";
	Random random = new Random();
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
	}
	
	
	@Test
	public void RandomItem() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// Adjust the timeout as needed
        
        WebElement container = driver.findElement(By.className("row-cols-xxl-4"));
        int items = container.findElements(By.className("product-item__inner")).size();
        System.out.println(items);
        WebElement randomItem = container.findElements(By.className("product-item__inner")).get(random.nextInt(items));
        
        // Scroll the random item into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomItem);
        wait.until(ExpectedConditions.elementToBeClickable(randomItem)); // Ensure the element is clickable
        
        try {
        
        	new Actions(driver).moveToElement(randomItem).click().perform();

        } catch (Exception e) {
            System.out.println("Normal click failed, attempting JavaScript click.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", randomItem); // Fallback to JavaScript click
        }
    }
	
	
	@AfterTest
	public void postTests() {}

}
