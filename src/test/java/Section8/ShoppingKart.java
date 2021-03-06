package Section8;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppingKart {

	static WebDriver driver;

	@Test
	public void Kart() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//******************IMPLICIT WAIT  - DECLARED GLOBALLY********//
		//***********applicable for all element, their is a performance issue in implicit wait********//
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//***********EXPLICIT WAIT - SELENIUM HAS AS CLASS TO ACHIEVE EXPLICIT WAIT ********//
		//************ explicit wait is applied only for targeted element *******//
		//************ No performance issue*********//
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5)); // creating a object to invoke method from the wait class
		
		System.out.println("Print");
		System.out.println("Testing");
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] vegs = { "Cucumber", "Tomato", "Beans" }; // Required items

		additems(driver, vegs);
		driver.findElement(By.xpath("//img[@alt = 'Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("RahulShettyAcademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public static void additems(WebDriver driver, String[] vegs) {
		int j = 0; // to declare the size of the string[] vegs

		List<WebElement> name = driver.findElements(By.xpath("//h4[@class='product-name']")); // getting the size of the
																								// product

		for (int i = 0; i < name.size(); i++) {
			String[] item = name.get(i).getText().split("-"); // getting text and splitting
			String formattedItem = item[0].trim(); // trimming the space
			List<String> addcart = Arrays.asList(vegs); // converting array to arraylist

			if (addcart.contains(formattedItem)) {
				j++; // increment according to the string length

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // selecting the
																										// required item
																										// after
																										// comparing
																										// with the list

				if (j == vegs.length) {
					break; // will break after completing vegs length
				}
			}

		}
	}
}
