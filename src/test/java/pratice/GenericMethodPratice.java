package pratice;

public class GenericMethodPratice {

	public static void main(String[] args) //caller function
	{
		
		// Addition
//		int a=10;
//		int b=20;
//		int c=a+b;
//		System.out.println(c);
		
		int sum= add(10,20);
		System.out.println(sum);

		System.out.println(add(30,sum));
		System.out.println(subtract(400,100));
		System.out.println(multiply(sum,60));
		System.out.println(divide(30,60));
		System.out.println(add(40,sum));
		
		int sum2= add(sum,80);
		System.out.println(sum2);
	}
	
	// logic controlled execution

	public static int add(int a,int b)//called function will be generic
	
	{
				
				int c=a+b;
				return c;
	}
public static int subtract(int a,int b)//called function will be generic
	
	{
				
				int c=a-b;
				return c;
	}
public static int multiply(int a,int b)//called function will be generic

{
			
			int c=a*b;
			return c;
}
public static int divide(int a,int b)//called function will be generic

{
			
			int c=a+b;
			return c;
}

}
