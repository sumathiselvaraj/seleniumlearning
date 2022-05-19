package Section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDropDown {

	static WebDriver driver;
	public static void main(String[] args) {
		
		
		// ******* launch browser using Web driver Manager**** // 
		// ***** webDriverMananger to launch the browser  without driver path and avoid version control *******//
		
			WebDriverManager.chromedriver().setup();
			
			//***** creating object for chromeDriver *****//
			driver = new ChromeDriver();
			
			// ***** launch the browser***//
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("http://3.110.88.201/dropdownsPractise/");
			
			//****** select no of pax****//
			driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
			
			//********** increasing the no of pax******//
			for(int i=1;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			}
			
			driver.findElement(By.id("btnclosepaxoption")).click();
			
			Select currency = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
			currency.selectByVisibleText("USD");
			System.out.println(currency.getFirstSelectedOption().getText());
			currency.selectByIndex(1);
			System.out.println(currency.getFirstSelectedOption().getText());
			currency.selectByValue("AED");
			System.out.println(currency.getFirstSelectedOption().getText());
	}
	

}
