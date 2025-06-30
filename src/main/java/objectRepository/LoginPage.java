package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule-1
{
	//Rule-2(Declaration)
	@FindBy(id="user-name")
	private WebElement usernameEdt;
	
	@FindBy(id="password")
	private WebElement passwordEdt;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	//Rule-3(Initialization)
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule-4(Utilization)
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
  //Business -generic methods--project specific
	
	public void loginToApp(String un, String pwd)
	{
		usernameEdt.sendKeys(un);
		passwordEdt.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	
	
	
	
	

}
