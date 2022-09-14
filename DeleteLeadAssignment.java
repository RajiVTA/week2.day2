package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadAssignment {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		// 1	Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 2 Enter the username
		//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCSR");
		
		// 3	Enter the password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		// 4	Click Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		// 5	Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		// 6	Click Leads link
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		
		// 7	Click Find leads
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		
		//8	Click on Phone
		//driver.findElement(By.xpath("//span[@class='x-tab-strip-inner' and text()='Phone']")).click();
		driver.findElement(By.xpath("//span[@class='x-tab-strip-inner']/span[text()='Phone']")).click();
		
		// 9	Enter phone number
		driver.findElement(By.xpath("//input[@id='ext-gen270']")).sendKeys("12345");
		//driver.findElement(By.xpath("//input[@id='ext-gen270']")).sendKeys("2147483647");
		//driver.findElement(By.xpath("//input[@id='ext-gen270']")).sendKeys("8220301148");
		
		// 10	Click find leads button
		driver.findElement(By.xpath("//td[@class='x-btn-center']//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		
		// 11	Capture lead ID of First Resulting lead

		WebElement firstResult = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		Thread.sleep(5000);
		String text = firstResult.getText();
		System.out.println("Record number is = " + text);
		
		//System.out.println("Lead ID of the first resulting lead = " +fResult);
		Thread.sleep(2000);
		
		//12	Click First Resulting lead
		firstResult.click();
		
		//13	Click Delete;
		//driver.findElement(By.xpath("//a[text()='Edit']/following-sibling::a")).click();
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		// 14	Click Find leads
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[text()='Find Leads']")).click();
		
		// 15	Enter captured lead ID
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='id']")).sendKeys(text);
		
		//driver.findElement(By.xpath("//div[@class='frameSectionExtra']//a[text()='Delete']")).click();
		
		
		// 16	Click find leads button
		driver.findElement(By.xpath("//td[@class='x-btn-center']//button[text()='Find Leads']")).click();
		
		
		// 17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement verifyMsg = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String verify=verifyMsg.getText();
		System.out.println("Verify message after deletion="+verify);
		
		if(verify.equals("No records to display"))
		{
			System.out.println("Successful deletion");
		}
		
		else
		{
			System.out.println("Not successful deletion");
		}
		
		// 18	Close the browser (Do not log out)
		//driver.close();
	}

}
