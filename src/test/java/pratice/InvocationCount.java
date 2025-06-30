package pratice;

import org.testng.annotations.Test;

public class InvocationCount 
{
	@Test(invocationCount=3, priority=2)
	public void create() 
	{
		System.out.println("create");
	}

	@Test(enabled=false)
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
