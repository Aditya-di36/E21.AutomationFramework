package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
/**
 * 
 */
public class ListenerImplemetationUtility  implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
		//Capture Method Name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test execution Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//Capture Method Name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//Capture Method Name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test FAIL");
				
		//Capture the Exception
		System.out.println(result.getThrowable());
		
		//Capture the screenshot
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		
		//Configure screenshot name
		
		String screenshotname= methodName+"--"+j.getSystemDate();
		
		try {
			s.captureScreenShot(BaseClass.sDriver, screenshotname);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		//Capture Method Name
				String methodName = result.getMethod().getMethodName();
				System.out.println(methodName+" Test SKIP");
				
				//Capture the Exception
				System.out.println(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("Suite Execution Started");
	
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("Suite Execution Finished");

	}
	

}
