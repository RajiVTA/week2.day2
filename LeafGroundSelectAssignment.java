package week2.day2;

import java.time.Duration;
import java.util.List;

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
		
		
		// Choose the course
		//driver.findElement(By.xpath("//select[@id='j_idt87:auto-complete_hinput']")).click();
		WebElement course = driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']"));
		course.click();
		driver.findElement(By.xpath("//span[@id='j_idt87:auto-complete_panel']//li[text()='Appium']")).click();
		
		// Select Language
		driver.findElement(By.xpath("//div[@id='j_idt87:lang']/label[@id='j_idt87:lang_label']")).click();
		driver.findElement(By.xpath("//ul[@id='j_idt87:lang_items']/li[text()='Tamil']")).click();
		
		// Select Two irrespective of the language shown
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[text()='Select Values']")).click();
		
		driver.findElement(By.xpath("//ul[@id='j_idt87:value_items']/li[@id='j_idt87:value_1']")).click();
		

	}

}
