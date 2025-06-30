package pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPratice {
	@Test(dataProvider="customerinfo")
	public void createCustomer(String name, int id)
	{
		//name id - 5 - run multiple times - different data
		//multiple customer
		
		System.out.println("The customer name is "+name);
		System.out.println("The customer id is "+id);
	}
	
	@DataProvider(name= "customerinfo") //row and columns
	public Object[][] getData()   // 4 sets of data and each set has 2 info
	{
		Object[][] data=new Object[4][2];
		
		//First data set
		data[0][0]="Neethu";
		data[0][1]=12;
		
		//Second data set
		data[1][0]="Meethu";
		data[1][1]=14;
				
		//Third data set
		data[2][0]="Peethu";
		data[2][1]=16;
				
		//First data set
		data[3][0]="Seethu";
		data[3][1]=18;
		
		return data;
	}

}
