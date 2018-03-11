package com.astrofitness.service;

import java.time.LocalDateTime;

public class FormatForumDateTime {
//merge
	/**
	 * 
	 * @param Time in index 0 and Date in index 1
	 * @return
	 */
	public static String[] getDayAndTime(LocalDateTime now){
		
		String DT = now.toString();
		String monthNum = DT.substring(5, 7);
		
		String month = "";
		switch(monthNum) {
			case "01":
				month = "January";
				break;
			case "02":
				month = "February";
				break;
			case "03":
				month = "March";
				break;
			case "04":
				month = "April";
				break;
			case "05":
				month = "May";
				break;
			case "06":
				month = "June";
				break;
			case "07":
				month = "July";
				break;
			case "08":
				month = "August";
				break;
			case "09":
				month = "September";
				break;
			case "10":
				month = "October";
				break;
			case "11":
				month = "November";
				break;
			case "12":
				month = "December";
				break;
		}
		
		String[] dateTime = new String[2];
		String year = DT.substring(0, 4);
		String day = DT.substring(8, 10);
		dateTime[0] = DT.substring(11, 19);
		dateTime[1] = month + " " + day + ", " + year;
		
		return dateTime;
	}
}
