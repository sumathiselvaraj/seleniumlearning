package Section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	
	static WebDriver driver;
	static String Name = "User";
	static String Expected = "Hello User, share this practice page and share your knowledge";

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//*************send name in Switch to Alert Example **************//
		driver.findElement(By.id("name")).sendKeys(Name);
		
		//************* click on alert button**********//
		driver.findElement(By.id("alertbtn")).click();
		
		//*********** capturing Text in the alert window ************//
		System.out.println(driver.switchTo().alert().getText());
		Assert.assertEquals(driver.switchTo().alert().getText(),Expected);
		
		//*********** accepting alert ( is to click on OK button)********// 
		driver.switchTo().alert().accept();
		
		//**********click on confirm button ************//
		driver.findElement(By.id("confirmbtn")).click();
		
		//*********** capturing Text in the alert window ************//
		System.out.println(driver.switchTo().alert().getText());
		
		
		//*********** accepting alert ( is to click on OK button)********//
		driver.switchTo().alert().dismiss();
				
	}

}
