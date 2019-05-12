package com.yl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		try {
			
			System.out.println(Arrays.toString(getTimeInterval(20190512)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *获取指定日期的本周日期
	 * @param dateTime   指定日期 yyyyMMdd
	 * @return
	 * @throws Exception
	 */
	public static Integer[] getTimeInterval(Integer dateTime) throws Exception{  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse(String.valueOf(dateTime));
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
        if (1 == dayWeek) {  
           cal.add(Calendar.DAY_OF_MONTH, -1);  
        }  
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期  
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
        cal.setFirstDayOfWeek(Calendar.MONDAY);  
        // 获得当前日期是一个星期的第几天  
        int day = cal.get(Calendar.DAY_OF_WEEK);  
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);  
        Integer[] weekDates = new Integer[7];
        for (int i = 0; i < weekDates.length; i++) {
			if( i>0 ) {
				Integer lastDate = weekDates[i - 1];
				cal.setTime(sdf.parse(String.valueOf(lastDate)));
				cal.add(Calendar.DATE, 1);
			}
			weekDates[i] = Integer.valueOf(sdf.format(cal.getTime()));
		}
        
        return weekDates;  
   }
}
