package Section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxAssign {

	static WebDriver driver;
	
	public static void main(String[]args) throws InterruptedException {
		
	// ******* launch browser using Web driver Manager**** // 
	// ***** webDriverMananger to launch the browser  without driver path and avoid version control *******//
	
		WebDriverManager.chromedriver().setup();
		
		//***** creating object for chromeDriver *****//
		driver = new ChromeDriver();
		
		// ***** launch the browser***//
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		
		//******** click the check box**********//
		driver.findElement(By.name("checkBoxOption1")).click();
		
		//********** verify its successfully checked*********//
		
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected());
		System.out.println(driver.findElement(By.name("checkBoxOption1")).isSelected());
		
		//******** click the check box to uncheck*********//
		driver.findElement(By.name("checkBoxOption1")).click();
		//********** verify its successfully unchecked*********//
		
       Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
		
			
       System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}
	
}
