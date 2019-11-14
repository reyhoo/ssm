package com.yl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_PATTERNS = "yyyy-MM-dd HH:mm:ss";

    public static Date formatDate(String dateStr, String pattern) {
        if (!StringUtils.isNotEmpty(dateStr))
            throw new IllegalArgumentException("date is null");
        if (pattern == null)
            throw new IllegalArgumentException("pattern is null");
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
           e.printStackTrace();
        }
        return date;
    }

    public static String getCurrentYear() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

    /**
     * 获取今日日期固定格式的字符串
     *
     * @return
     */
    public static String getCurrentDateYYYYMMDD() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    /**
     * 获取今日日期固定格式的字符串
     *
     * @return
     */
    public static String getCurrentDateYYYYMMDDHH() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        return sdf.format(date);
    }

    /**
     * 获取今日日期"yyyyMMddHHmmss"格式的字符串
     *
     * @return
     */
    public static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    public static String getCurTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 获取今日日期固定格式的字符串
     *
     * @return
     */
    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 获取今日日期固定格式的字符串
     *
     * @return
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String dateFormat(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 获取date相隔几个小时（前、后）的时间
     *
     * @param date
     * @param hour
     * @return date（+、- hour）小时后的时间
     */
    public static Date getAnyTimeByNow(Date date, int hour) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, hour);
        return c.getTime();
    }

    /**
     * 根据传入的日期，获取相隔分钟的时间
     *
     * @param date
     * @param anyTime 可正可负
     * @return
     */
    public static Date getAnyDateByNow(Date date, int anyTime) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, anyTime);
        return c.getTime();
    }

    /**
     * @param oriDate    原比较时间
     * @param targetDate 相比较时间
     * @param anyTime    原比较时间前后天数，可正可负
     * @return -1:先于；0:相等；1:晚于
     */
    public static int compareDateWithAnyDay(Date oriDate, Date targetDate, Integer anyTime) {
        int flag = 0;

        try {
            if (anyTime == null) {
                anyTime = 0;
            }
            Date date = new Date();
            if (oriDate == null) {
                oriDate = getAnyDateByNow(date, anyTime);
            } else {
                oriDate = getAnyDateByNow(oriDate, anyTime);
            }
            flag = compareDate(oriDate, targetDate);
        } catch (Exception e) {
            flag = 2;
            e.printStackTrace();
        }
        return flag;
    }

    public static int compareDate(Date smallDate, Date bigDate) {
        return compareDate(smallDate, bigDate, new SimpleDateFormat("yyyyMMdd"));
    }

    /**
     * 比较两个日期的先后, day1先于day2 返回 -1 ,相等返回0 ,晚于返回1<br/>
     * 默认格式为yyyyMMdd,若需指定格式传递第三个格式字段
     */
    public static int compareDate(Date smallDate, Date bigDate, SimpleDateFormat sdf) {
        try {
            return sdf.parse(sdf.format(smallDate)).compareTo(sdf.parse(sdf.format(bigDate)));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("日期格式有误 ");
        }
    }

    /**
     * smallTime 是否在bigTime 之前
     *
     * @param smallTime
     * @param bigTime
     * @return
     */
    public static boolean isBeforeOrEquals(Date smallTime, Date bigTime) {
        return compareDate(smallTime, bigTime, new SimpleDateFormat("yyyyMMdd HH:mm:ss")) <= 0;
    }

    /**
     * 2个时间相隔几分钟
     *
     * @param smdate
     * @param bdate
     * @return
     */
    public static int minuteBetween(Date smdate, Date bdate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_minutes = (time2 - time1) / (1000 * 60);
        return Integer.parseInt(String.valueOf(between_minutes));
    }

    /**
     * 返回yyyy-MM-dd格式的字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        return simpleDateFormat.format(date);
    }

    /**
     * 返回yyyyMMddHHmmss格式的字符串
     *
     * @param date
     * @return
     */
    public static String dateToString14(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(date);
    }

    /**
     * 根据起始日和相隔天数计算终止日
     *
     * @param startDate
     * @param days
     * @return
     */
    public static Date getEndDateByDays(Date startDate, int days) {
        Calendar calendarStartDate = Calendar.getInstance();
        calendarStartDate.setTime(startDate);
        calendarStartDate.add(Calendar.DAY_OF_YEAR, days);
        return calendarStartDate.getTime();
    }

    /**
     * String 转成TIMESTAMP
     */

    public static Timestamp getTimestamp(String times, String t) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp ts = null;
        if (StringUtils.isNotEmpty(times)) {
            try {
                Date dateTime = sdf.parse(times + t);
                ts = new Timestamp(dateTime.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("转换错误");
            }
        }
        return ts;
    }

    public static Timestamp getTimestamps(String times) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Timestamp ts = null;
        if (StringUtils.isNotEmpty(times)) {
            try {
                Date dateTime = sdf.parse(times);
                ts = new Timestamp(dateTime.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("转换错误");
            }
        }
        return ts;
    }

    public static Timestamp getTimestamps(String times, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Timestamp ts = null;
        if (StringUtils.isNotEmpty(times)) {
            try {
                Date dateTime = sdf.parse(times);
                ts = new Timestamp(dateTime.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("转换错误");
            }
        }
        return ts;
    }

    public static String getTimestampStr(Timestamp times, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(times);
    }

    /**
     * 校验时间格式
     *
     * @param times        时间字符串
     * @param date_pattern 校验格式
     * @param message      错误返回提示
     * @throws FuiouException
     */
    public static Date checkDate(String times, String date_pattern, String message) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(date_pattern);
        try {
            date = sdf.parse(times);
            if (date == null) {
                throw new RuntimeException(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return date;
    }

    public static java.sql.Date getJavaSqlDateAfterNowByNo(Date date,int anyDay) {
		if(date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_WEEK, anyDay);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return new java.sql.Date(c.getTime().getTime());
	}

    /**
     * 根据传入的日期，获取相隔天数日期
     *
     * @param date
     * @param anyDay 可正可负
     * @return
     */
    public static Date getAnyDayByNo(Date date, int anyDay) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_WEEK, anyDay);
        return c.getTime();
    }

    /**
     * 计算传入日期月份的后i个月份
     */
    public static Date getNextMonth(Date date,int i)  {
        String sytle = "yyyy-MM-dd";
        Date nextDate = new Date();
        String result = null;
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, i);
            SimpleDateFormat sdfmt = new SimpleDateFormat(sytle);
            result = sdfmt.format(calendar.getTime());
            nextDate = sdfmt.parse(result);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期转换错误");
        }
        return nextDate;
    }

    /**
     * 获取传入日期月份的后i个月份，后的j天
     *
     * @param i
     * @param j
     * @return
     */
    public static Date getNextMonthMinusDays(Date date ,int i, int j) {
    	Date d = null;
        try {
        	 d = getNextMonth(date, i);
        	if(j < 0 && isLastDayOfMonth(d)) {
        		Calendar cal = Calendar.getInstance();
        		cal.setTime(date);
        		Calendar cal2 = Calendar.getInstance();
        		cal2.setTime(d);
        		int days = cal.get(Calendar.DATE) - cal2.get(Calendar.DATE);
        		if(days < (-j)) {
        			d = getAnyDayByNo(d, j + days);
        		}
        	}else {
        		d = getAnyDayByNo(d, j);
        	}
        } catch (Exception e) {
            e.printStackTrace();
            // throw new FuiouException(",日期转换错误");
        }
        return d;
    }

    @SuppressWarnings("deprecation")
	public static boolean isLastDayOfMonth(Date date)   {  
        Calendar cDay1 = Calendar.getInstance();  
        cDay1.setTime(date);  
        final  int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);  
        Date lastDate = cDay1.getTime();  
        lastDate.setDate(lastDay);  
        return compareDate(lastDate, date) == 0;  
}
    /**
     * 日期，去除时分秒
     *
     * @return
     */
    public static Date getDateRemoveTime() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();

    }

    public static Date getAnySecondsByNow(Date date, int anyTime) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, anyTime);
        return c.getTime();
    }

    public static Date getAnyMilliSecondsByNow(Date date, int anyTime) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MILLISECOND, anyTime);
        return c.getTime();
    }
    
	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws FuiouException
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		smdate = getDateRemoveTime(smdate);
		bdate = getDateRemoveTime(bdate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
	/**
	 * 日期，去除时分秒
	 * @return
	 */
	public static Date getDateRemoveTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
    /**
     * 字符串日期转Date 参数格式：yyyy-MM-dd HH:mm:ss
     *
     * @param times
     * @return
     */
    public static Date getDateByString(String times) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date ts = null;
        if (StringUtils.isNotEmpty(times)) {
            try {
                Date dateTime = sdf.parse(times);
                ts = dateTime;
            } catch (ParseException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("转换错误");
            }
        }
        return ts;
    }

    /**
     * 判断夜间1，白天0 夜间：0时 < T < 6时； 白天： 6时 <= T <= 24时
     *
     * @return
     */
    public static String isNight(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
        Date now = null;
        Date beginTime = null;
        Date endTime = null;
        try {
            now = df.parse(df.format(date));
            beginTime = df.parse("00:00");
            endTime = df.parse("06:00");
            Boolean flag = belongCalendar(now, beginTime, endTime);
            if (flag) {
                return "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";

    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
	 * 计算传入日期获取前i(负数)个月份或后i(正数)个月份的日期
	 * 
	 * @param i(可正可负)
	 *            转换的格式
	 * @return
	 */
	public static Date getNearbyMonth(Date nowDate,int i) {
		String sytle = "yyyy-MM-dd HH:mm:ss";
		Date nextDate = new Date();
		String result = null;
		Calendar calendar = Calendar.getInstance();

		try {
			calendar.setTime(nowDate);
			calendar.add(Calendar.MONTH, i);
			SimpleDateFormat sdfmt = new SimpleDateFormat(sytle);
			result = sdfmt.format(calendar.getTime());
			nextDate = sdfmt.parse(result);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("日期转换错误");
		}
		return nextDate;
	}
	
	public static String getDateformatDate(Date date, String pattern){
		if(date != null && StringUtils.isNotEmpty(pattern)){
			SimpleDateFormat sdfmt = new SimpleDateFormat(pattern);
			return sdfmt.format(date);
		}
		return "";
	}
	
	public static String getTimestampz(Date date) {
		String timestamp = null;
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
		timestamp = dfm.format(date);
		return timestamp;
	}
	public static String getTimestampz() {
		String timestamp = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
		timestamp = dfm.format(cal.getTime());
		return timestamp;
	}
	/**
	 * 获取中文日期串
	 * 
	 * @param date
	 * @return
	 */
	public static String getChinaDate(Date date) {
		return new SimpleDateFormat("yyyy年MM月dd日").format(date);
	}

    /**
     * 获取day号日期
     * @param date
     * @return
     */
	public static Date getEveryMonthByDay(Date date,String day) {
	    String str = dateFormat(date,DATE_PATTERN);
	    str = str.substring(0,str.length()-2).concat(day);
	    return formatDate(str,DATE_PATTERN);
    }

    public static Date getLastDay(int year,int month){

        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return cal.getTime();
    }

	public static void main(String[] args) {
	    try {
	        String d = "2019-06-04";
	        Date dd = formatDate(d,"yyyy-MM-dd");
            Date endDate = DateUtils.formatDate("2019-11-10","yyyy-MM-dd");
            Date sss  = DateUtils.getAnyDateByNow(dd,5);
            sss = DateUtils.formatDate(DateUtils.dateFormat(sss,"yyyy-MM-dd"),"yyyy-MM-dd");
            System.out.println(DateUtils.compareDate(sss,endDate,new SimpleDateFormat("yyyy-MM-dd")));

	      /*  System.out.println(DateUtils.getCurrentDateYYYYMMDD().substring(6));
	        System.out.println(DateUtils.getEveryMonthByDay(new Date(),"22"));
            Date nowDate = DateUtils.formatDate("2019-11-07","yyyy-MM-dd");
            Date lendingDate = DateUtils.formatDate("2019-11-05","yyyy-MM-dd");
            Date lendingDate2 = DateUtils.formatDate("2019-11-08","yyyy-MM-dd");
            System.out.println(DateUtils.belongCalendar(nowDate,lendingDate,lendingDate2));*/
        }catch (Exception e){
	        e.printStackTrace();
        }
    }
}
