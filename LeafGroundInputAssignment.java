package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundInputAssignment {

	public static void main(String[] args) throws InterruptedException {
	
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://leafground.com/input.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter Name
		WebElement nameInput = driver.findElement(By.xpath("//div[@class='col-12']/input[@name='j_idt88:name']"));
		//nameInput.clear();
		nameInput.sendKeys("Eswari");
		
		// Append country to city
		driver.findElement(By.xpath("//input[@value='Chennai']")).sendKeys("  India");
		
		//Verify if text box is disabled
		boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
		System.out.println("Text box enabled status is  = "  +enabled);
		
		// Clear the typed text
		driver.findElement(By.name("j_idt88:j_idt95")).clear();
		
		// Retrieve the typed text
		String att = driver.findElement(By.name("j_idt88:j_idt97")).getAttribute("value");
		System.out.println("Attribute fetch = " +att);
		Thread.sleep(4000);
		
		// Email and Tab, Confirm control moved to next element
		
		String oldTitle = driver.getTitle();
		System.out.println("Old title is = " +oldTitle);
		
		driver.findElement(By.xpath("//input[@name='j_idt88:j_idt99']")).sendKeys("1234567890",Keys.TAB);
		Thread.sleep(3000);
		String newTitle = driver.getTitle();
		System.out.println("New title = " +newTitle);
		
		if(oldTitle.equals(newTitle))
		{
			System.out.println("Control does NOT move to next element");
		}
		else
		{
			System.out.println("Control moves to next element");
		}
		//Type about yourself
		WebElement textArea = driver.findElement(By.xpath("//textarea[@name='j_idt88:j_idt101']"));
		textArea.sendKeys("I am a Tester");
		
		// Press Enter and confirm error message
		
		driver.findElement(By.xpath("//input[@name='j_idt106:thisform:age']")).sendKeys(Keys.ENTER);
		String errorMsg = driver.findElement(By.xpath("//span[@class='ui-message-error-detail']")).getText();
		System.out.println("Error message = " + errorMsg);
		
		// Click and confirm label position changes
		WebElement orgPositionEle = driver.findElement(By.xpath("//input[@id='j_idt106:float-input']"));
			
		Point location4 = driver.findElement(By.xpath("//label[text()='Username']")).getLocation();
		System.out.println("Original location of username label is ="+location4);
		orgPositionEle.click();
				
		Point location3 = driver.findElement(By.xpath("//label[text()='Username']")).getLocation();
		System.out.println("New location of username label is = " +location3);
		
		
		
	}

}
