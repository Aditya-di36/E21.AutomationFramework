package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility 
{
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date=s.format(d);
		return date;
	}

}
