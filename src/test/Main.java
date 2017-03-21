package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Date d = new Date();
		
		
		System.out.println(new SimpleDateFormat("yyyyMMdd").format(d));
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d));
	}

}
