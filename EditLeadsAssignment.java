package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadsAssignment {

	public static void main(String[] args) throws InterruptedException {
	
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		// 1	Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// 2	Enter the username
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
		
		// 9	Click Find leads button
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		
		//driver.findElement(By.xpath("//input[@id='x-form-el-ext-gen248']/div")).sendKeys("Shivu");
		driver.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Pandiyan");
		
		// 10 Click on first resulting lead
		driver.findElement(By.xpath("//button[@id='ext-gen334']")).click();
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		// 11 Verify title of the page
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		if(pageTitle.equals("View Lead | opentaps CRM"))
			System.out.println("Title is matching");
		else
			System.out.println("Title is not matching");
		
		// 12 Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		
		// 13 Change the company name
		WebElement coName = driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']"));
		coName.clear();
		coName.sendKeys("XYZ Ltd");
		//driver.findElement(By.xpath("//input[@id='ext-gen626']")).click();
		
		// 14 Click Update
		driver.findElement(By.xpath("//td[@colspan='4']/input[@class='smallSubmit']")).click();
		Thread.sleep(4000);
		
		WebElement updateCoName = driver.findElement(By.xpath("//span[contains(text(),'XYZ Ltd')]"));
		String textCo = updateCoName.getText();
		
		// 15 Confirm the changed name appears
		Thread.sleep(4000);
		if(textCo.contains("XYZ Ltd"))
		//if(textCo.contains("XYZ Ltd (10194)"))
		{
			System.out.println("Name is updated");
		}
		else
		{
			System.out.println("Name is NOT updated");
		}
		
		// 16 Close the browser (Do not log out)
		//driver.close(); 
		
		}

}
