package com.highill.base.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTool {

	public static final String DATE_TIME_FULL_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * get day start time
	 * 
	 * @param date
	 * @return day start Date
	 */
	public static Date dayStart(Date date) {
		Date dayStart = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			dayStart = calendar.getTime();
		}
		return dayStart;
	}

	/**
	 * format date with dateFormat
	 * @param date
	 * @param dateFormat
	 * @return date format string
	 */
	public static String format(Date date, String dateFormat) {
		String format = null;
		try {
			if (date != null && dateFormat != null && !dateFormat.trim().isEmpty()) {
				SimpleDateFormat simpleFormat = new SimpleDateFormat(dateFormat.trim());
				format = simpleFormat.format(date);
			}
		} catch (Exception e) {
			
		}
		return format;
	}
	
	/**
	 * format date with {@value #DATE_TIME_FULL_FORMAT}
	 * @param date
	 * @return format string
	 */
	public static String formatDateTimeFull(Date date) {
		String format = format(date, DATE_TIME_FULL_FORMAT);
		return format;
	}
	
	/**
	 * parse a string to Date
	 * @param date
	 * @param dateFormat
	 * @return parse Date
	 */
	public static Date parse(String date, String dateFormat) {
		Date parseDate = null;
		try {
			if(date != null && !date.trim().isEmpty() && dateFormat != null && !dateFormat.trim().isEmpty()) {
				SimpleDateFormat simpleFormat = new SimpleDateFormat(dateFormat.trim());
				parseDate = simpleFormat.parse(date);
			}
		} catch(Exception e) {
			
		}
		
		return parseDate;
	}
	
	/**
	 * parse {@value #DATE_TIME_FULL_FORMAT} to Date
	 * @param date
	 * @return parse Date
	 */
	public static Date parseDateTimeFull(String date) {
		Date parseDate = parse(date, DATE_TIME_FULL_FORMAT);
		return parseDate;
	}

}
