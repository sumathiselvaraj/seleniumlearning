package Section8;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppingKart {
	
	static WebDriver driver;
	
	
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		
		String[] vegs = {"Cucumber","Tomato","Beans"}; // Required items
		int j = 0; // to declare the size of the string[] vegs
		
		List<WebElement> name = driver.findElements(By.xpath("//h4[@class='product-name']")); // getting the size of the product
		
		
		
		for (int i=0;i<name.size();i++) 
		{	
			String[] item = name.get(i).getText().split("-"); // getting text and splitting 
			String formattedItem = item[0].trim(); // trimming the space
			List<String> addcart = Arrays.asList(vegs); // converting array to arraylist 
			
			if(addcart.contains(formattedItem)) {
				j++; // increment according to the string length
				
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // selecting the required item after comparing with the list
				
				if(j==vegs.length) 
				{
					break;  // will break after completing vegs length
			}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
