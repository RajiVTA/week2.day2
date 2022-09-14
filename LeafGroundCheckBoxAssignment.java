package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckBoxAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Basic checkbox
		driver.findElement(By.xpath("//div[@id='j_idt87:j_idt89']")).click();
		
		// Ajax
		driver.findElement(By.xpath("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();
				
		
		// Verify if checkbox is disabled
		boolean enabled = driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']/parent::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-disabled ui-state-disabled']")).isEnabled();
		System.out.println("Checkbox enabled status="+enabled);
	
	}

}
