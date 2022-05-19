package Section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCalender {
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
			driver.get("http://3.110.88.201/dropdownsPractise/");
			//Thread.sleep(1000);
			
			//****************** clicking on the origin station *********//
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			
			//******** select the city *********//
			driver.findElement(By.xpath("//a[@value='DEL']")).click();
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
			
			//************selecting current date ************//
		
			driver.findElement(By.cssSelector(".ui-state-default ui-state-highlight.ui-state-highlight")).click(); // when you find space in class switch to cssSelector instead of xpath
		
			
			
			
			
	}

}
