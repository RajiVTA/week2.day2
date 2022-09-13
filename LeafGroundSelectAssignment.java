package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundSelectAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://leafground.com/select.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Which is your favorite UI Automation tool?
		WebElement autoTool = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select auto=new Select(autoTool);
		auto.selectByVisibleText("Selenium");
		
		
		// Choose your preferred country.
			
		driver.findElement(By.xpath("//label[@id='j_idt87:country_label']")).click();
		driver.findElement(By.xpath("//ul[@id='j_idt87:country_items']/li[text()='India']")).click();
		
		// Confirm Cities belongs to Country is loaded
		try {
	
		WebElement citiesEle = driver.findElement(By.xpath("//div[@id='j_idt87:city']//span[@class='ui-icon ui-icon-triangle-1-s ui-c']"));
		driver.executeScript("arguments[0].click()", citiesEle);
		Thread.sleep(4000);
		}
		catch(Exception E)
		{
			System.out.println("Invalid xpath");
		}
		
		// Select Language
		driver.findElement(By.xpath("//div[@id='j_idt87:lang']/label[@id='j_idt87:lang_label']")).click();
		driver.findElement(By.xpath("//ul[@id='j_idt87:lang_items']/li[text()='Tamil']")).click();
		
			
		

	}

}
