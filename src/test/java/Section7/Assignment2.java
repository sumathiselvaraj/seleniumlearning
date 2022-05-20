package Section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {


	
		static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {
			
			// ******* launch browser using Web driver Manager**** // 
			// ***** webDriverMananger to launch the browser  without driver path and avoid version control *******//
			

			WebDriverManager.chromedriver().setup();
			
			//***** creating object for chromeDriver *****//
			driver = new ChromeDriver();
				
				// ***** launch the browser***//
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get("https://rahulshettyacademy.com/angularpractice/");
				
				//********** drop down, Edit box , error validation*********//
				
				driver.findElement(By.name("name")).sendKeys("Naveen");
				driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid")).sendKeys("naveenlearning@gmail.com");
				driver.findElement(By.id("exampleInputPassword1")).sendKeys("Water");
				driver.findElement(By.xpath("//input[@class='form-check-input']")).click();
				
				Select gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
				gender.selectByVisibleText("Male");
				
				driver.findElement(By.id("inlineRadio1")).click();
				driver.findElement(By.name("bday")).sendKeys("05/20/1983");
				
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				//String a=driver.findElement(By.xpath("//strong[contains(text(),'Success!')]")).getText();
//
	//			System.out.println(a);
				
				//System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
				
//				//String expectedalert = " The Form has been submitted successfully!";
     			WebElement actualalert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//				
//				
				String alert = actualalert.getText();System.out.println(alert);
				
				//String alert1 = alert.replace("x", " ");
				//if (alert1.equals("  Success! The Form has been submitted successfully!.")) {System.out.println(alert1);}else {System.out.println("no");}
				
			
				
	}

}
