package com.highill.base.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTool {

	public static final String DATE_TIME_FULL_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * date add day number
	 * 
	 * @param date
	 *            target date
	 * @param dayNumber
	 *            day number
	 * @return target date add day number Date
	 */
	public static Date dayAdd(Date date, int dayNumber) {
		Date dayAdd = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			calendar.add(Calendar.DAY_OF_YEAR, dayNumber);

			dayAdd = calendar.getTime();
		}
		return dayAdd;
	}

	/**
	 * day end time
	 * 
	 * @param date
	 *            target day
	 * @return day end Date
	 */
	public static Date dayEnd(Date date) {
		Date dayEnd = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			calendar.set(Calendar.MILLISECOND, 999);
			dayEnd = calendar.getTime();
		}
		return dayEnd;
	}

	/**
	 * get day start time
	 * 
	 * @param date
	 *            target date
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
	 * date add month number
	 * 
	 * @param date
	 *            target date
	 * @param monthNumber
	 *            month number
	 * @return target date add month Date
	 */
	public static Date monthAdd(Date date, int monthNumber) {
		Date monthAdd = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			calendar.add(Calendar.MONTH, monthNumber);

			monthAdd = calendar.getTime();
		}
		return monthAdd;
	}

	/**
	 * month end Date
	 * 
	 * @param date
	 *            target date
	 * @return month end Date
	 */
	public static Date monthEnd(Date date) {
		Date monthEnd = null;
		if (date != null) {
			Date nextMonthStart = nextMonthStart(date);
			Date monthLastDay = dayAdd(nextMonthStart, -1);
			monthEnd = dayEnd(monthLastDay);
		}
		return monthEnd;
	}

	/**
	 * month start Date
	 * 
	 * @param date
	 *            target date
	 * @return month start Date
	 */
	public static Date monthStart(Date date) {
		Date monthStart = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			monthStart = calendar.getTime();
		}
		return monthStart;
	}

	/**
	 * date add one day
	 * 
	 * @param date
	 *            target date
	 * @return date add one day
	 */
	public static Date nextDay(Date date) {
		Date nextDay = dayAdd(date, 1);
		return nextDay;
	}

	/**
	 * next day start Date
	 * 
	 * @param date
	 *            target date
	 * @return next day start Date
	 */
	public static Date nextDayStart(Date date) {
		Date nextDay = nextDay(date);
		Date nextDayStart = dayStart(nextDay);
		return nextDayStart;
	}

	/**
	 * next month Date
	 * 
	 * @param date
	 *            target date
	 * @return next month Date
	 */
	public static Date nextMonth(Date date) {
		Date nextMonth = monthAdd(date, 1);
		return nextMonth;
	}

	/**
	 * next month start Date
	 * 
	 * @param date
	 *            target date
	 * @return next month start Date
	 */
	public static Date nextMonthStart(Date date) {
		Date nextMonth = nextMonth(date);
		Date nextMonthStart = monthStart(nextMonth);
		return nextMonthStart;
	}

	/**
	 * next year Date
	 * 
	 * @param date
	 *            target Date
	 * @return next year Date
	 */
	public static Date nextYear(Date date) {
		Date nextYear = yearAdd(date, 1);
		return nextYear;
	}

	/**
	 * next year start Date
	 * 
	 * @param date
	 *            target Date
	 * @return next year start Date
	 */
	public static Date nextYearStart(Date date) {
		Date nextYear = nextYear(date);
		Date nextYearStart = yearStart(nextYear);
		return nextYearStart;
	}

	/**
	 * format date with dateFormat
	 * 
	 * @param date
	 *            target date
	 * @param dateFormat
	 *            target SimpleDateFormat string
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
			System.out.println(e);
		}
		return format;
	}

	/**
	 * format date with {@value #DATE_TIME_FULL_FORMAT}
	 * 
	 * @param date
	 *            target date
	 * @return format string
	 */
	public static String formatDateTimeFull(Date date) {
		String format = format(date, DATE_TIME_FULL_FORMAT);
		return format;
	}

	/**
	 * parse a string to Date
	 * 
	 * @param date
	 *            target date
	 * @param dateFormat
	 *            target SimpleDateFormat string
	 * @return parse Date
	 */
	public static Date parse(String date, String dateFormat) {
		Date parseDate = null;
		try {
			if (date != null && !date.trim().isEmpty() && dateFormat != null && !dateFormat.trim().isEmpty()) {
				SimpleDateFormat simpleFormat = new SimpleDateFormat(dateFormat.trim());
				parseDate = simpleFormat.parse(date);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return parseDate;
	}

	/**
	 * parse {@value #DATE_TIME_FULL_FORMAT} to Date
	 * 
	 * @param date
	 *            target date
	 * @return parse Date
	 */
	public static Date parseDateTimeFull(String date) {
		Date parseDate = parse(date, DATE_TIME_FULL_FORMAT);
		return parseDate;
	}

	/**
	 * date add year number
	 * 
	 * @param date
	 *            target Date
	 * @param yearNumber
	 *            add year number
	 * @return date add year number Date
	 */
	public static Date yearAdd(Date date, int yearNumber) {
		Date yearAdd = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			calendar.add(Calendar.YEAR, yearNumber);

			yearAdd = calendar.getTime();
		}
		return yearAdd;
	}

	/**
	 * year end
	 * 
	 * @param date
	 *            year end Date
	 * @return year end Date
	 */
	public static Date yearEnd(Date date) {
		Date yearEnd = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			calendar.set(Calendar.MONTH, Calendar.DECEMBER);
			calendar.set(Calendar.DAY_OF_MONTH, 31);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			calendar.set(Calendar.MILLISECOND, 999);

			yearEnd = calendar.getTime();
		}
		return yearEnd;
	}

	/**
	 * year start
	 * 
	 * @param date
	 *            year start Date
	 * @return year start Date
	 */
	public static Date yearStart(Date date) {
		Date yearStart = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			calendar.set(Calendar.MONTH, Calendar.JANUARY);
			calendar.set(Calendar.DAY_OF_YEAR, 1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			yearStart = calendar.getTime();
		}
		return yearStart;
	}

}
