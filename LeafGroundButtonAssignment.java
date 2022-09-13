package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButtonAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://leafground.com/button.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Verify title
		String oldTitle = driver.getTitle();
		System.out.println(oldTitle);
		
		//Click button
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
		String newTitle = driver.getTitle();
		System.out.println(newTitle);
		//Title comparision
		if(oldTitle.equals(newTitle))
		{
			System.out.println("Title is NOT changed");
		}
		else
		{
			System.out.println("Title is changed");
		}
		
		driver.navigate().back();
		
		//To check button is disabled
		boolean buttonEnabled = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt92']")).isEnabled();
		System.out.println("Button is = "+ buttonEnabled);
		
		//Find the postition of the Submit button
		Point location = driver.findElement(By.xpath("//span[text()='Submit']")).getLocation();
		System.out.println("The location of the Submit button = " +location);
		
		//Find the save button color
		WebElement colorElement = driver.findElement(By.xpath("//span[text()='Save']"));
		String cssValue = colorElement.getCssValue("Color");
		System.out.println("Color of Save button = "+cssValue);
		
		//Find height and width of the button
		Dimension size = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']")).getSize();
		System.out.println("The size of button is = " +size);
		
		//Mouse hover color change
		
		Actions action = new Actions(driver);
		WebElement mouseEle = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']"));
		String cssValue2 = mouseEle.getCssValue("background-color");
		System.out.println("Color of Submit button before Mouse Hover=  "+cssValue2);
		action.moveToElement(mouseEle).build().perform();
		Thread.sleep(4000);
		
		WebElement mouseEle2 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']/span[text()='Success']"));
		String cssValue3= mouseEle2.getCssValue("background-color");
		System.out.println("Color of Submit button after Mouse Hover=  "+cssValue3); 
		
		//Color change verification
		if(cssValue2.equals(cssValue3))
			System.out.println("Success color did not change");
		else
			System.out.println("Success color changes");
		
		//Click Image Button and Click on any hidden button
		
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt102:imageBtn']")).click();
		  
	    WebElement findElement = driver.findElement(By.xpath("//img[@id='j_idt88:j_idt102:j_idt104']"));
	    driver.executeScript("arguments[0].click();", findElement);
	

	}

}
