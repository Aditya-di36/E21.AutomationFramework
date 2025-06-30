package inventory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddLowestPriceProductToCartTest {

	@Test
	public void tc_002_AddLowestPriceProductToCartTest() throws Exception
	{

		// Create Object of Utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();

		// Read the Common data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		// Read the Test Data from Excel file
		String SORTOPTION = fUtil.readDataFromExcelFile("Products", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 4, 3);

		// Launch the Browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		// Load the URL
		driver.get(URL);

		// Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnLowestPriceProduct(driver,SORTOPTION,PRODUCTNAME);

		// Add Product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddcartBtn();

		// Navigate to Cart
		ip.clickOnCartContainerBtn();

		// Validate for the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.captureItemName();

		if (productInCart.equals(PRODUCTNAME)) {
			System.out.println(productInCart);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Logout of Application
		ip.logoutOfApp();
	}

}