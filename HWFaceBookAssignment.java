package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HWFaceBookAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[@ajaxify='/reg/spotlight/']")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Create New Account']")).click();
		
		
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Eswari");
		
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("M");
		
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("123456780");
		
		// Step 10: Enter the password
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("TestLeaf123");
		
		// Step 11: Handle all the three drop downs
		WebElement dayDrop = driver.findElement(By.xpath("//select[@id='day']"));
		Select sel=new Select(dayDrop);
		sel.selectByValue("3");
		
		WebElement monthDrop = driver.findElement(By.xpath("//select[@id='month']"));
		Select mon=new Select(monthDrop);
		mon.selectByVisibleText("Mar");
		
		WebElement yearDrop = driver.findElement(By.xpath("//select[@id='year']"));
		Select yr=new Select(yearDrop);
		yr.selectByIndex(20);
		
	
		// Step 12: Select the radio button "Female" 
		driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']/input")).click();
		
		
	}

}

