package LG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
	
	
	@Test(priority = 1,enabled = true)
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
	
	@Test(priority = 2 , enabled = true)
	public void AddtoCart() {
	    WebElement Addbtn = driver.findElement(By.cssSelector(".single_add_to_cart_button.button"));
		Addbtn.click();
		
		String ActualText = driver.findElement(By.cssSelector("div[role='alert']")).getText();
		assertEquals(ActualText.contains("added to your cart"), true);
		
	}
	
	@Test(priority = 3, enabled = true)
	public void signUp() {
	    driver.findElement(By.cssSelector(".header-icon.header-icon__user-account.dropdown.animate-dropdown")).click();
	    System.out.println("Clicked the dropdown toggle successfully.");
	    driver.findElement(By.cssSelector(".sign-in-button")).click();
	}
	
	@Test(enabled = true , priority = 4)
	public void Register() throws InterruptedException {
		WebElement emailInpt=driver.findElement(By.id("reg_email"));
		emailInpt.sendKeys("dddd@gmail.com");
		
		
		WebElement passInput =driver.findElement(By.id("reg_password"));
		passInput.sendKeys(passwords[RandPassword]);
		
		WebElement dateInput =driver.findElement(By.id("billing_birth_date"));
		dateInput.sendKeys(datesOfBirth[RandDates]+"");
		Thread.sleep(3000);
		
		WebElement btn = driver.findElement(By.cssSelector("button[value='Register']"));
		btn.click();
		
		String ActualText = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > main:nth-child(1) > article:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > p:nth-child(2)")).getText();
       assertEquals(ActualText.contains("Hello"), true);

		
		
		
	}
	
	@Test(priority = 5,enabled = true)
	public void changePassword() {
		driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > main:nth-child(1) > article:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > p:nth-child(3) > a:nth-child(3)")).click();
		
		WebElement current = driver.findElement(By.id("password_current"));
		current.sendKeys(passwords[RandPassword]);
		
		WebElement newPass = driver.findElement(By.id("password_1"));
		newPass.sendKeys("Amal@1478dd");
		
		WebElement confirmPass = driver.findElement(By.id("password_2"));
		confirmPass.sendKeys("Amal@1478dd");
		
		driver.findElement(By.name("save_account_details")).click();
		
	}


	
	

	
	
	
	
	@AfterTest
	public void postTests() {}

}
