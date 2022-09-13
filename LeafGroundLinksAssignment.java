package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLinksAssignment {

	public static void main(String[] args) throws InterruptedException {
				
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Take me to Dashboard
		driver.findElement(By.xpath("//a[text()='Go to Dashboard']")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		
		// Total number of links
		int size = driver.findElements(By.tagName("a")).size();
		System.out.println("Total number of links in this page is = " +size);
		
	
		
		

	}

}
