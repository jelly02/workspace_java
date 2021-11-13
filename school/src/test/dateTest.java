package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTest {

	public static void main(String[] args) {
		
		
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			Date now = new Date(); 
			String now_dt = format.format(now);
		
			String last = now_dt.trim();
			
			System.out.println(last);
		
	}
}
