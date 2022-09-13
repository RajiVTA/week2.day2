package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundRadioButtonAssignment {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://leafground.com/radio.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		
		// 1. Your most favorite browser
		driver.findElement(By.xpath("//table[@id='j_idt87:console1']//div")).click();
		
		// 2. Unselectable
		
		WebElement click1 = driver.findElement(By.xpath("//label[text()='Bengaluru']"));
		click1.click();
		/*boolean unselectElement1 = click1.isSelected();
		System.out.println(unselectElement1);*/
		Thread.sleep(2000);
		
		WebElement click2 = driver.findElement(By.xpath("//label[text()='Bengaluru']"));
		click2.click();
		Thread.sleep(1000);
		boolean unselectElement2 = click2.isSelected();
		if(unselectElement2)
		{
			System.out.println("After second click, it is selected");
		}
		else
		{
			System.out.println("After second click, Element is UNSELECTED");	
		}
		
		
		// 3. Find the default select radio button
		boolean defaultRadio = driver.findElement(By.xpath("//table[@id='j_idt87:console2']//input[@id='j_idt87:console2:2']")).isSelected();
		System.out.println(defaultRadio);
		if(defaultRadio)
		{
			System.out.println("Safari is the default browser");
		}
		
		else
		{
			System.out.println("Safari is not the default browser");
		} 
		
		// 4. Select the age group (only if not selected)
		
		 WebElement ageEle = driver.findElement(By.xpath("//div[@class='ui-radiobutton ui-widget']//input[@id='j_idt87:age:1']"));
		 boolean agee = ageEle.isSelected();
		 System.out.println(agee);
		 if(agee)
		 {
		 System.out.println("Age group 21-40 years is the default age group");
		 }
		 else
		 {
		 System.out.println("Age group 21-40 years is not the default age group");
		 }
	}

}
