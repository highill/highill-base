package com.highill.base.calendar;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.MethodSorters;

import junit.framework.TestCase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(BlockJUnit4ClassRunner.class)
public class CalendarToolTest {

	@Test
	public void dayAdd() {
		int dayNumber = 5;
		Map<String, String> dayAddMap = new LinkedHashMap<String, String>();
		dayAddMap.put("2017-07-01 11:22:33.123", "2017-07-06 11:22:33.123");
		dayAddMap.put("2017-07-28 22:33:44.001", "2017-08-02 22:33:44.001");
		dayAddMap.put("2017-12-30 12:12:12.111", "2018-01-04 12:12:12.111");

		for (String dateTimeString : dayAddMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date dayAdd = CalendarTool.dayAdd(dateParam, dayNumber);
			String dayAddFormat = CalendarTool.formatDateTimeFull(dayAdd);
			System.out.println("----- dayAdd param: " + dateTimeString + "  " + dayNumber + "  dayAdd is " + dayAddFormat);
			TestCase.assertEquals(dayAddMap.get(dateTimeString), dayAddFormat);
		}
	}

	@Test
	public void dayEnd() {
		Map<String, String> dayEndMap = new LinkedHashMap<String, String>();
		dayEndMap.put("2017-07-01 11:22:33.123", "2017-07-01 23:59:59.999");
		dayEndMap.put("2017-08-01 22:33:44.001", "2017-08-01 23:59:59.999");
		dayEndMap.put("2018-01-01 01:02:03.111", "2018-01-01 23:59:59.999");

		for (String dateTimeString : dayEndMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date dayEnd = CalendarTool.dayEnd(dateParam);
			String dayEndFormat = CalendarTool.formatDateTimeFull(dayEnd);
			System.out.println("----- dayEnd param: " + dateTimeString + "  dayEnd is " + dayEndFormat);
			TestCase.assertEquals(dayEndMap.get(dateTimeString), dayEndFormat);
		}
	}

	@Test
	public void dayStart() {
		Map<String, String> dayStartMap = new LinkedHashMap<String, String>();
		dayStartMap.put("2017-07-01 11:22:33.123", "2017-07-01 00:00:00.000");
		dayStartMap.put("2017-08-01 22:33:44.999", "2017-08-01 00:00:00.000");
		dayStartMap.put("2018-01-01 01:02:03.001", "2018-01-01 00:00:00.000");

		for (String dateTimeString : dayStartMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date dayStart = CalendarTool.dayStart(dateParam);
			String dayStartFormat = CalendarTool.formatDateTimeFull(dayStart);
			System.out.println("----- dayStart param: " + dateTimeString + "  dayStart is " + dayStartFormat);
			TestCase.assertEquals(dayStartMap.get(dateTimeString), dayStartFormat);
		}

	}

	@Test
	public void monthAdd() {
		int monthNumber = 3;
		Map<String, String> monthAddMap = new LinkedHashMap<String, String>();
		monthAddMap.put("2017-07-01 11:22:33.123", "2017-10-01 11:22:33.123");
		monthAddMap.put("2017-08-31 22:33:44.111", "2017-11-30 22:33:44.111");
		monthAddMap.put("2017-12-30 12:12:12.001", "2018-03-30 12:12:12.001");

		for (String dateTimeString : monthAddMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date monthAdd = CalendarTool.monthAdd(dateParam, monthNumber);
			String monthAddFormat = CalendarTool.formatDateTimeFull(monthAdd);
			System.out.println("----- monthAdd dateTimeString: " + dateTimeString + "  " + monthNumber + "  monthAdd is " + monthAddFormat);
			TestCase.assertEquals(monthAddMap.get(dateTimeString), monthAddFormat);
		}
	}

	@Test
	public void monthEnd() {
		Map<String, String> monthEndMap = new LinkedHashMap<String, String>();
		monthEndMap.put("2017-07-01 11:22:33.123", "2017-07-31 23:59:59.999");
		monthEndMap.put("2017-08-20 22:33:44.234", "2017-08-31 23:59:59.999");
		monthEndMap.put("2017-11-29 12:12:12.111", "2017-11-30 23:59:59.999");

		for (String dateTimeString : monthEndMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date monthEnd = CalendarTool.monthEnd(dateParam);
			String monthEndFormat = CalendarTool.formatDateTimeFull(monthEnd);
			System.out.println("----- monthEnd dateTimeString: " + dateTimeString + "  monthEnd is " + monthEndFormat);
			TestCase.assertEquals(monthEndMap.get(dateTimeString), monthEndFormat);
		}
	}

	@Test
	public void monthStart() {
		Map<String, String> monthStartMap = new LinkedHashMap<String, String>();
		monthStartMap.put("2017-07-10 11:22:33.123", "2017-07-01 00:00:00.000");
		monthStartMap.put("2017-02-28 23:34:45.999", "2017-02-01 00:00:00.000");
		monthStartMap.put("2018-01-30 12:12:12.111", "2018-01-01 00:00:00.000");

		for (String dateTimeString : monthStartMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date monthStart = CalendarTool.monthStart(dateParam);
			String monthStartFormat = CalendarTool.formatDateTimeFull(monthStart);
			System.out.println("----- monthStart dateTimeString: " + dateTimeString + "  monthStart is " + monthStartFormat);
			TestCase.assertEquals(monthStartMap.get(dateTimeString), monthStartFormat);
		}
	}

	@Test
	public void nextDay() {
		Map<String, String> nextDayMap = new LinkedHashMap<String, String>();
		nextDayMap.put("2017-07-01 11:22:33.123", "2017-07-02 11:22:33.123");
		nextDayMap.put("2017-08-10 22:33:44.234", "2017-08-11 22:33:44.234");
		nextDayMap.put("2017-12-31 12:12:12.121", "2018-01-01 12:12:12.121");

		for (String dateTimeString : nextDayMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date nextDay = CalendarTool.nextDay(dateParam);
			String nextDayFormat = CalendarTool.formatDateTimeFull(nextDay);
			System.out.println("----- nextDay dateTimeString: " + dateTimeString + "  nextDay is " + nextDayFormat);
			TestCase.assertEquals(nextDayMap.get(dateTimeString), nextDayFormat);
		}
	}

	@Test
	public void nextDayStart() {
		Map<String, String> nextDayStartMap = new LinkedHashMap<String, String>();
		nextDayStartMap.put("2017-07-01 11:22:33.123", "2017-07-02 00:00:00.000");
		nextDayStartMap.put("2017-08-10 22:33:44.234", "2017-08-11 00:00:00.000");
		nextDayStartMap.put("2017-12-31 12:12:12.121", "2018-01-01 00:00:00.000");

		for (String dateTimeString : nextDayStartMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date nextDayStart = CalendarTool.nextDayStart(dateParam);
			String nextDayStartFormat = CalendarTool.formatDateTimeFull(nextDayStart);
			System.out.println("----- nextDayStart dateTimeString: " + dateTimeString + "  nextDayStart is " + nextDayStartFormat);
		}
	}

	@Test
	public void nextMonth() {
		Map<String, String> nextMonthMap = new LinkedHashMap<String, String>();
		nextMonthMap.put("2017-07-01 11:22:33.123", "2017-08-01 11:22:33.123");
		nextMonthMap.put("2017-08-31 22:33:44.234", "2017-09-30 22:33:44.234");
		nextMonthMap.put("2017-12-31 12:12:12.111", "2018-01-31 12:12:12.111");

		for (String dateTimeString : nextMonthMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date nextMonth = CalendarTool.nextMonth(dateParam);
			String nextMonthFormat = CalendarTool.formatDateTimeFull(nextMonth);
			System.out.println("----- nextMonth dateTimeString: " + dateTimeString + "  nextMonth is " + nextMonthFormat);
			TestCase.assertEquals(nextMonthMap.get(dateTimeString), nextMonthFormat);
		}
	}

	@Test
	public void nextMonthStart() {
		Map<String, String> nextMonthStartMap = new LinkedHashMap<String, String>();
		nextMonthStartMap.put("2017-07-01 11:22:33.123", "2017-08-01 00:00:00.000");
		nextMonthStartMap.put("2017-08-20 22:33:44.234", "2017-09-01 00:00:00.000");
		nextMonthStartMap.put("2017-12-31 12:12:12.111", "2018-01-01 00:00:00.000");

		for (String dateTimeString : nextMonthStartMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date nextMonthStart = CalendarTool.nextMonthStart(dateParam);
			String nextMonthStartFormat = CalendarTool.formatDateTimeFull(nextMonthStart);
			System.out.println("----- nextMonthStart dateTimeString: " + dateTimeString + "  nextMonthStart is " + nextMonthStartFormat);
			TestCase.assertEquals(nextMonthStartMap.get(dateTimeString), nextMonthStartFormat);
		}
	}

}
