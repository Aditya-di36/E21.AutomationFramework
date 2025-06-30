package pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngPratice 
{
	@Test
	public void create() //create a customer
	{
		Assert.fail();
		System.out.println("create");
	}

	@Test(dependsOnMethods = "create")
	public void modify() 
	{
		System.out.println("modify");
	}

	@Test
	public void delete() 
	{
		System.out.println("delete");
	}


}
