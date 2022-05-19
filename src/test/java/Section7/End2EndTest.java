package Section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class End2EndTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		//***** creating object for chromeDriver *****//
		driver = new ChromeDriver();
			
			// ***** launch the browser***//
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("http://3.110.88.201/dropdownsPractise/");
			driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.xpath("//a[@value='BLR']")).click();
			driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		   
			if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {  System.out.println("disabled") ;Assert.assertTrue(true);}
			driver.findElement(By.id("divpaxinfo")).click();
			int i =1;
			
		     for(i=1;i<5;i++){  driver.findElement(By.id("hrefIncAdt")).click(); }
		     driver.findElement(By.id("hrefIncChd")).click();
		     driver.findElement(By.xpath("//input[@class='buttonN']")).click();
		     driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		     driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		     driver.close();
		     
				
			}
		

	}


