package com.tms.GenericUtility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method is used to get random
	 * @author ELANGO
	 * @return
	 */

	public int getRandom() {
		Random ran=new Random();
		int random=ran.nextInt(500);
        return random;
	}
	/**
	 * This method is used to get the system date
	 * @author ELANGO
	 */
	public String getSystemDate() {
		Date d=new Date();
		String date=d.toString();
		return date;
		}
	/**
	 * this method is used to get the system date in format
	 * @author ELANGO
	 * @return
	 */
	public String getSystemDateInFormat() {
		
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
		Date date=new Date();
		String systemDateInformat=dateformat.format(date);
		return systemDateInformat;
		
	}		

}
