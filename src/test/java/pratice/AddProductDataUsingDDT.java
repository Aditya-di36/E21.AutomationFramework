package pratice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductDataUsingDDT 
{

	public static void main(String[] args) throws Exception 
	{

		// Read the common data from property file
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder\\Selenium Programs\\E21.AutomationFramework\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");

		// Read the test data from excel file
		FileInputStream fise=new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder\\Selenium Programs\\E21.AutomationFramework\\src\\test\\resources\\E21 AutomationFramework.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Products");
		Row rw = sh.getRow(1);
		Cell cl = rw.getCell(2);
		String PRODUCTNAME = cl.getStringCellValue();
		

		//launch the browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Load the browser
		driver.get(URL);

		//Login to the application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();

		//click on the product to add to cart
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		driver.findElement(By.id("add-to-cart")).click();

		//Navigate to the cart
		driver.findElement(By.id("shopping_cart_container")).click();

		//Validate the product
		String productInCart=driver.findElement(By.className("inventory_item_name")).getText();

		if(productInCart.equals(PRODUCTNAME))
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