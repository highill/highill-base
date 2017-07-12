package com.highill.base.calendar;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import junit.framework.TestCase;

@RunWith(BlockJUnit4ClassRunner.class)
public class CalendarToolTest {

	
	@Test
	public void dayStart() {
		Map<String, String> dayStartMap = new LinkedHashMap<String, String>();
		dayStartMap.put("2017-07-01 11:22:33.123", "2017-07-01 00:00:00.000");
		dayStartMap.put("2017-08-01 22:33:44.999", "2017-08-01 00:00:00.000");
		dayStartMap.put("2018-01-01 01:02:03.001", "2018-01-01 00:00:00.000");
		
		for(String dateTimeString : dayStartMap.keySet()) {
			Date dateParam = CalendarTool.parseDateTimeFull(dateTimeString);
			Date dayStart = CalendarTool.dayStart(dateParam);
			String dayStartFormat = CalendarTool.formatDateTimeFull(dayStart);
			System.out.println("----- dayStart param: " + dateTimeString + "  dayStart is " + dayStartFormat);
			TestCase.assertEquals(dayStartMap.get(dateTimeString), dayStartFormat);
		}
		
		
	}
}
