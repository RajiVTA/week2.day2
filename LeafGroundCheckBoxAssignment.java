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
		
		
		//Select Multiple
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//ul[@role='group']/li[contains(@class,'selectcheckboxmenu')]"));
		System.out.println("Total number of items in select multiple is = "+checkBoxes.size());
		
		/*for(int i=0;i<checkBoxes.size();i++)
		{
			checkBoxes.get(i).click();
			 
	        String value = checkBoxes.get(i).getAttribute("value");
	        System.out.println("Value of checkbox is = "+value);
		} */
		//Thread.sleep(3000);
		//driver.close();
	}

}
