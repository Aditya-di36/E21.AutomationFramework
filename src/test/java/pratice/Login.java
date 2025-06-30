package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {

	public static void main(String[] args) 
	{
		//launch the browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Load the browser
		driver.get("https://www.saucedemo.com/");
		
		//Login to the application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//click on the product to add to cart
		driver.findElement(By.xpath("//div[.='Sauce Labs Bike Light']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		
		//Navigate to the cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Validate the product
		String productInCart=driver.findElement(By.className("inventory_item_name")).getText();
		
		if(productInCart.equals("Sauce Labs Bike Light"))
		{
			System.out.println(productInCart);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout of the application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		

	}

}
