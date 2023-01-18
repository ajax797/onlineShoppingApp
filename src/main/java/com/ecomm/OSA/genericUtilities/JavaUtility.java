package com.ecomm.OSA.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	public int getRandomNum()
	{
		Random ran = new Random();
		int random = ran.nextInt(100);
		return random;
		
	}
	
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	 public static String getSystemDateAndTimeInFormat()
	 {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		  Date SysDate = new Date();
		String getDateAndTime = dateFormat.format(SysDate);
		return getDateAndTime;
	 }
	
}
