package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility 
{
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void manimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void handleDropdown(int index, WebElement element)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void handleDropdown(WebElement element, String visibleText)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
	}
	public void handleDropdown(String value, WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element);
	}
		public void dragAndDrop(WebDriver driver, WebElement srcele, WebElement targele)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcele, targele);
	}
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void clickAndHoldAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	public void releaseAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.release(element).perform();
	}
	public void ScollAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	public void switchToFrame(WebDriver driver, int frameindex)
	{
		driver.switchTo().frame(frameindex);
	}
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public void switchToWindow(WebDriver driver, String windowID)
	{
		driver.switchTo().window(windowID);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	public void EnterAlertData(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}
	public String captureScreenShot(WebDriver driver, String screenshotName) throws Exception 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\Screenshot\\"+screenshotName+".png");
		FileHandler.copy(src, dst);
		
		
		return dst.getAbsolutePath();
		
	}
	
	
	
	
	
}
