package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

@Listeners(genericUtilities.ListenerImplemetationUtility.class)
public class Login extends BaseClass

{
	@Test(groups = "SmokeSuite")
	public  void tc_001_Login() throws Exception 
	{

    	// Read the Test Data from Excel file
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 1, 2);

       // Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnAProduct(driver, PRODUCTNAME);
	
		//Add Product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		  iip.clickOnAddcartBtn();
		
		// Navigate to Cart
		ip.clickOnCartContainerBtn();

		// Validate for the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.captureItemName();
		Assert.assertEquals(productInCart, PRODUCTNAME);
	}

	
     @Test(groups = "RegressionSuite")
     public void sample()
     {
    	// Assert.fail();
    	 System.out.println("Demo");
    	 
     }
     
}