package Section8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign3 {

	static WebDriver driver;
	static WebDriverWait wait;
	static Select option;
	static String name = "rahulshettyacademy";
	static String password = "learning";
	static String options = "Consultant";

	@Test
	public void assignment(){

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // object for explicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // implicit wait
		driver.manage().window().maximize();
		 
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.name("username")).sendKeys(name);
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
	    driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		option = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		option.selectByVisibleText(options);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link btn btn-primary']")));
		List <WebElement> product = driver.findElements(By.xpath("//div[@class='card-footer']"));
		
		for(int i=0;i<product.size();i++) {
			
			product.get(i).click();
		}
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		

	}

}
