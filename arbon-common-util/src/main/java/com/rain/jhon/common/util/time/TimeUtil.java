package com.rain.jhon.common.util.time;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.rain.jhon.common.util.collection.CollectionUtil;


/**
 * <p>功能描述:</br> 时间处理的工具类</p>
 * 
 * @className TimeUtil
 * @author jiangyu
 * @date 2016年3月31日 下午9:52:57
 * @version v1.0
 */
public class TimeUtil
{
    /** 转换的日期格式 **/
    public static String PATTERN_DATE_1 = "yyyy-MM-dd";

    public static String PATTERN_DATE_2 = "yyyyMMdd";

    public static String PATTERN_DATE_3 = "yyyyMMddhhMMss";

    public static String PATTERN_DATE_4 = "yyyy-MM-dd HH:mm:ss:SSS";

    public static String PATTERN_DATE_5 = "yyyy年MM月dd日";

    public static String PATTERN_DATE_6 = "yyyy-MM-dd HH:mm";

    public static String PATTERN_DATE_7 = "yyyy-MM-dd HH:mm:ss";

    public static String PATTERN_DATE_8 = "yyyy-MM-dd HH";

    public static String PATTERN_DATE_9 = "MMdd";

    public static String PATTERN_DATE_10 = "yyMMddHHmmss";

    public static String PATTERN_DATE_11 = "yyyyMMddHHMMss";

    public static String PATTERN_TIME_1 = "HH:mm";

    public static String PATTERN_TIME_2 = "HH:mm:ss";

    public static String PATTERN_YEAR_1 = "yyyy";

    public static String STARTTIME_SUFFIX = " 00:00:00";

    public static String ENDTIME_SUFFIX = " 23:59:59";
    
    public static String YEAR_LAST_DAY = " 12-31";

    public static Integer MAX_CONTINIOUS_DAYS = 10000;

    public static final SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_DATE_7);
    
    /** 一年的秒 **/
    public static final Long YEAR_OF_MILLISON_SECONDS = 31536000000L;
    /** 一个月的秒（30天）**/
    public static final Long MONTH_OF_MILLISON_SECONDS = 2592000000L;
    /** 一天的秒（24h天）**/
    public static final Integer DAY_OF_MILLISON_SECONDS = 86400000;
    /** 一小时的秒 **/
    public static final Integer HOUR_OF_MILLISON_SECONDS = 3600000;
    /** 一分钟的秒 **/
    public static final Integer MINUTE_OF_MILLISON_SECONDS = 60000;
    

    /**
     * <p> 功能描述：将字符串时间转换为date类型的时间</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:53:16
     * @param dateTime
     * @param pattern
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date parseDate(String dateTime, String pattern)
    {
        Date date = null;
        if (!CollectionUtil.isEmpty(dateTime))
        {
            try
            {
                date = new SimpleDateFormat(pattern).parse(dateTime);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        return date;
    }

    /**
     * <p> 功能描述：获取默认的当前时间</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:53:29
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getDefaultCurrentDateTime()
    {
        return getTimeStr(new Date(), TimeUtil.PATTERN_DATE_7);
    }

    /**
     * <p> 功能描述：将时间转为指定格式的字符串</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:53:40
     * @param date
     * @param pattern
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getTimeStr(Date date, String pattern)
    {
        if (null == date)
        {
            return "";
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * <p> 功能描述：TODO</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:53:54
     * @param pattern
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getTimeStr(String pattern)
    {
        return getTimeStr(new Date(), pattern);
    }

    /**
     * <p> 功能描述：TODO</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:54:03
     * @param pattern
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getTimeStrExcpBeginZero(String pattern)
    {
        String result = getTimeStr(new Date(), pattern);
        if (!CollectionUtil.isEmpty(result))
        {
            if ("0".equals(result.substring(0, 1)))
            {
                result = result.substring(1);
            }
        }
        return result;
    }

    /**
     * <p> 功能描述：TODO</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:54:12
     * @param date
     * @param pattern
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getTimeStrExcpBeginZero(Date date, String pattern)
    {
        String result = getTimeStr(date, pattern);
        if (!CollectionUtil.isEmpty(result))
        {
            if ("0".equals(result.substring(0, 1)))
            {
                result = result.substring(1);
            }
        }
        return result;
    }

    public static String getTimeStrExcpBeginZero(Date date, String pattern, boolean isTrue)
    {
        String result = getTimeStr(date, pattern);
        if (!CollectionUtil.isEmpty(result))
        {
            if (isTrue)
            {
                if ("0".equals(result.substring(0, 1)))
                {
                    result = result.substring(1);
                }
            }
        }
        return result;
    }

    /**
     * <p> 功能描述：将日期转换为字符串</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:54:22
     * @param date
     * @param patten
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String Date2Sring(Date date, String patten)
    {
        if (CollectionUtil.isEmpty(date))
        {
            return "";
        }
        if (CollectionUtil.isEmpty(patten))
        {
            patten = PATTERN_DATE_1;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        return sdf.format(date);
    }

    /**
     * <p> 功能描述：获取指定范围的随机数</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:54:39
     * @param start
     * @param end
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static int getRandom(int start, int end)
    {
        return start + ((int)(Math.random() * 10 * (end - start + 2)) % (end - start + 1));
    }

    /**
     * <p> 功能描述：获得两个日期之间相差的天数</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:54:52
     * @param time1
     *            开始时间
     * @param time2
     *            结束时间
     * @param patten
     *            两个日期之间相差的天数
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static long getQuot(String time1, String time2, String patten)
    {
        long quot = 0;
        SimpleDateFormat ft = new SimpleDateFormat(patten);
        try
        {
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);

            quot = date2.getTime() - date1.getTime();
            quot = quot / 1000 / 60 / 60 / 24;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return quot;
    }

    /**
     * <p> 功能描述：将Timestamp时间转为指定格式的字符串</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:55:29
     * @param timestamp
     * @param pattern
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getTimestampStr(Timestamp timestamp, String pattern)
    {
        if (null == timestamp)
        {
            return "";
        }

        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis(timestamp.getTime());
        return new SimpleDateFormat(pattern).format(c.getTime());
    }

    /**
     * <p> 功能描述：TODO</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:55:40
     * @param string
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getTimestampDateFromString(String string)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_4);
        try
        {
            Date date = dateFormat.parse(string);
            Timestamp timestamp = new Timestamp(date.getTime());
            return timestamp;
        }
        catch (ParseException e)
        {}
        return new Date();
    }

    /**
     * <p> 功能描述：TODO</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:55:50
     * @param string
     * @param format
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getTimestampDateFromString(String string, String format)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try
        {
            Date date = dateFormat.parse(string);
            Timestamp timestamp = new Timestamp(date.getTime());
            return timestamp;
        }
        catch (ParseException e)
        {}
        return new Date();
    }

    /**
     * <p> 功能描述：获取某年某月最大天数</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:55:59
     * @param year
     *            年
     * @param month
     *            月
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static int getMaxDay(String year, String month)
    {
        // 计算某一月份的最大天数
        Calendar time = Calendar.getInstance();
        time.clear(); // 若不clear，很多信息会继承自系统当前时间
        time.set(Calendar.YEAR, Integer.valueOf(year));
        time.set(Calendar.MONTH, Integer.valueOf(month) - 1);
        int day = time.getActualMaximum(Calendar.DAY_OF_MONTH); // 本月总天数
        return day;
    }

    public static Timestamp getTimeStamp(String timeStr)
    {
        Date date = getTimestampDateFromString(timeStr);
        Timestamp time = new Timestamp(date.getTime());
        return time;
    }

    public static Timestamp getTimeStamp(Date date)
    {
        Timestamp time = new Timestamp(date.getTime());
        return time;
    }

    /**
     * <p> 功能描述：计算传入时间与当前时间的相隔天数 </p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:56:23
     * @param timestamp
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static long getDays(Timestamp timestamp)
    {
        long currentTime = System.currentTimeMillis();
        long temp = timestamp.getTime();
        long dayslong = currentTime - temp;
        long days = (dayslong >> 10) / 84375;
        long l_days = (long)days;
        return l_days;
    }

    public static Timestamp getTimeStamp(String timeStr, String pattern)
    {
        DateFormat format = new SimpleDateFormat(pattern);
        format.setLenient(false);
        try
        {
            Timestamp ts = new Timestamp(format.parse(timeStr).getTime());
            return ts;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDateFromString(String date, String fmt)
        throws Exception
    {
        if (date == null || date.trim().length() == 0) return null;
        DateFormat df = new SimpleDateFormat(fmt);
        return df.parse(date);
    }

    /**
     * <p> 功能描述：将字符串转换为时间</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:56:41
     * @param str
     * @param pattern
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getDateFormatString(String str, String pattern)
    {
        if (str != null && !str.trim().equals(""))
        {
            try
            {
                return new SimpleDateFormat(pattern).parse(str);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
                return null;
            }
        }
        else
        {
            return null;
        }

    }

    /**
     * <p> 功能描述：获取两个时间差(格式:XX天XX小时XX分XX秒)</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:56:52
     * @param startDate
     * @param endDate
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getTwoDateDiff(Date startDate, Date endDate)
    {
        long l = endDate.getTime() - startDate.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long sed = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        return "" + day + "天" + hour + "小时" + min + "分" + sed + "秒";

    }

    /**
     * <p> 功能描述：获取两个时间的间隔天数</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:57:04
     * @param startDate
     * @param endDate
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Long getTwoDay(Date startDate, Date endDate)
    {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String endTempDate = myFormatter.format(endDate.clone());
        String startTempDate = myFormatter.format(startDate.clone());
        try
        {
            return ((myFormatter.parse(endTempDate).getTime()) - (myFormatter.parse(startTempDate).getTime())) / (24 * 60 * 60 * 1000);
        }
        catch (ParseException e)
        {
            return -1L;
        }
    }

    /**
     * <p> 功能描述：获取当前日期的开始时间可结束时间</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:58:07
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static List<Date> getBeginAndEndDate()
    {
        List<Date> preDates = new ArrayList<Date>();
        preDates.add(getTodayBeginTime());
        preDates.add(getTodayEndTime());
        return preDates;
    }

    /**
     * <p> 功能描述：获取今天的开始时间</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:58:17
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getTodayBeginTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE_7);
        Date begin = null;
        try
        {
            String baseTimeStr = getBaseDateStr();
            String beginTime = baseTimeStr + STARTTIME_SUFFIX;
            begin = sdf.parse(beginTime);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return begin;
    }

    /**
     * <p> 功能描述：获取今天的结束时间</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:58:28
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getTodayEndTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE_7);
        Date end = null;
        try
        {
            String baseTimeStr = getBaseDateStr();
            String endTime = baseTimeStr + ENDTIME_SUFFIX;
            end = sdf.parse(endTime);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return end;
    }

    /**
     * <p> 功能描述：获取某一天的开始时间</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 下午5:10:35
     * @param Date
     *            date 特定日期
     * @return String 特定日期的开始时间
     * @version v1.0
     * @since V1.0
     */
    public static String getSomeDayBeginTime(Date date)
    {
        String baseTimeStr = getBaseDateStr(date);
        return baseTimeStr + STARTTIME_SUFFIX;
    }

    /**
     * <p> 功能描述：获取次日的开始时间 </p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 下午5:21:50
     * @return 次日开始时间
     * @version v1.0
     * @since V1.0
     */
    public static String getNextDayBeginTime()
    {
        String result = "";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        result = formatter.format(calendar.getTime());
        return result;
    }

    /**
     * <p> 功能描述：获取间隔xx天数后的日期</p>
     * 
     * @author jiangyu
     * @date 2016年10月24日 上午11:32:07
     * @param days
     *            间隔的天数
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getIntervalTimeOfDays(Date beginDate, int days)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * <p> 功能描述：获取间隔xx月数后的日期</p>
     * 
     * @author jiangyu
     * @date 2016年10月24日 下午6:28:11
     * @param beginDate
     * @param months
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getIntervalTimeOfMonths(Date beginDate, int months)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    /**
     * <p> 功能描述：获取某一天的结束时间</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 下午5:16:39
     * @param Date
     *            date 特定日期
     * @return String 特定日期的结束时间
     * @version v1.0
     * @since V1.0
     */
    public static String getSomeDayEndTime(Date date)
    {
        String baseTimeStr = getBaseDateStr(date);
        return baseTimeStr + ENDTIME_SUFFIX;
    }

    /**
     * <p> 功能描述：距离当前时间的多少天之后的结束时间</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 下午7:48:20
     * @param day
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getSomeDayEndTime(int day)
    {
        String result = "";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day + 1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        result = formatter.format(calendar.getTime());
        return result;
    }
    
    /**
     * <p> 功能描述：获取间隔时间的日期</p>
     * @author  jiangyu
     * @date  2016年11月24日 上午10:33:51
     * @param day 间隔的天数 
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getIntervalDayEndTime(int day)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * <p> 功能描述：TODO</p>
     * 
     * @author jiangyu
     * @date 2016年9月18日 下午4:15:02
     * @param day
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getSomeDayEndTime(String baseDateStr, int day)
    {
        String result = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(TimeUtil.getDateFormatString(baseDateStr, TimeUtil.PATTERN_DATE_7));
        calendar.add(Calendar.DATE, day);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        result = formatter.format(calendar.getTime());
        return result;
    }

    public static String getSomeMonthEndTime(int month)
    {
        String result = "";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, month);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        result = formatter.format(calendar.getTime());
        return result;
    }

    public static String getSomeMonthEndTime(String baseDateStr, int month)
    {
        String result = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(TimeUtil.getDateFormatString(baseDateStr, TimeUtil.PATTERN_DATE_7));
        calendar.add(Calendar.MONTH, month);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        result = formatter.format(calendar.getTime());
        return result;
    }

    /**
     * <p> 功能描述：获取当前日期</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:58:38
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getBaseDateStr()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE_1);
        return sdf.format(new Date());
    }

    /**
     * <p> 功能描述：TODO</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 下午5:11:39
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getBaseDateStr(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE_1);
        return sdf.format(date);
    }

    /**
     * <p> 功能描述：TODO</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 下午5:11:32
     * @param patten
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getBaseDateStr(String patten)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        return sdf.format(new Date());
    }

    /**
     * <p> 功能描述：获取日期的星期几</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:58:52
     * @param dt
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getDateOfWeek(Date dt)
    {
        String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) w = 0;
        return weekDays[w];
    }

    /**
     * <p> 功能描述：日期的天</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:59:03
     * @param dt
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Integer getDateOfDay(Date dt)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * <p> 功能描述：日期的月</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:59:17
     * @param dt
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Integer getDateOfMonth(Date dt)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * <p> 功能描述：获取日期的年份 </p>
     * 
     * @author jiangyu
     * @date 2016年10月23日 下午3:02:22
     * @param date
     *            提取的日期
     * @return 年份
     * @version v1.0
     * @since V1.0
     */
    public static Integer getDateOfYear(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.YEAR);
        return month;
    }

    /**
     * <p> 功能描述：日期中天的尾数</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:59:27
     * @param dt
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Integer getDayOfSuffix(Date dt)
    {
        int day = getDateOfDay(dt);
        return day % 10;
    }

    /**
     * <p> 功能描述：获取当前日期是星期几</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:59:38
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getCurrentDateOfWeek()
    {
        Date date = new Date();
        return getDateOfWeek(date);
    }

    /**
     * <p> 功能描述：获取当前日期的天</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:59:49
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Integer getCurrentDateOfDay()
    {
        Date date = new Date();
        return getDateOfDay(date);
    }

    /**
     * <p> 功能描述： 获取当前日期的月</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午10:00:07
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Integer getCurrentDateOfMonth()
    {
        Date date = new Date();
        return getDateOfMonth(date);
    }
    
    /**
     * <p> 功能描述：获取指定日期所属的月</p>
     * @author  jiangyu
     * @date  2016年10月25日 下午3:53:25
     * @param date
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Integer getSpecialDateOfMonth(Date date)
    {
        return getDateOfMonth(date);
    }

    /**
     * <p> 功能描述：获取当前日期中天的尾数</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午10:00:20
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Integer getCurrentDayOfSuffix()
    {
        Date date = new Date();
        return getDayOfSuffix(date);
    }

    /**
     * <p> 功能描述：获取当前的年份</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午10:00:31
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getCurrentYear()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year + "";
    }
    
    /**
     * <p> 功能描述：获取当年最后一天 </p>
     * @author  jiangyu
     * @date  2016年10月24日 下午6:32:28
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getCurrentYearLastDay()
    {
        String datetimeStr = getCurrentYear()+"-"+YEAR_LAST_DAY+""+ENDTIME_SUFFIX;
        return TimeUtil.getDateFormatString(datetimeStr, TimeUtil.PATTERN_DATE_7);
    }

    public static String getCurrentPreviousYear()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return (year - 1) + "";
    }

    public static String getCurrentNextYear()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return (year + 1) + "";
    }

    /**
     * <p> 功能描述：获取当前月第一天</p>
     * 
     * @author jiangyu
     * @date 2016年10月19日 下午4:19:32
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getCurrentMonthDayBeginTime()
    {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, 0);
        ca.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        return ca.getTime();
    }

    /**
     * <p> 功能描述：获取当前月最后一天</p>
     * 
     * @author jiangyu
     * @date 2016年10月19日 下午4:19:36
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getCurrentMonthDayEndTime()
    {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        return ca.getTime();
    }

    public static void main(String[] args)
    {
        // Calendar cal = Calendar.getInstance();
        // int day = cal.get(Calendar.DATE); // 日
        // int month = cal.get(Calendar.MONTH) + 1;// 月
        // int year = cal.get(Calendar.YEAR); // 年
        //
        // System.out.println("Date: " + cal.getTime());
        // System.out.println("Day: " + day);
        // System.out.println("Month: " + month);
        // System.out.println("Year: " + year);
        //
        // System.out.println(getTimeStrExcpBeginZero(TimeUtil.PATTERN_DATE_9));
//        System.out.println(getCurrentMonthDayBeginTime());
//        System.out.println(getCurrentMonthDayEndTime());
        System.out.println(getQuot("2016-10-29", "2017-02-06", "yyyy-MM-dd"));
    }

    /**
     * <p> 功能描述：校验时间是否过期</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午10:00:44
     * @param compareDate
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static boolean validateTimeIsExpired(Date compareDate)
    {
        if (compareDate != null)
        {
            return compareDate.getTime() < System.currentTimeMillis();
        }
        else
        {
            return false;
        }
    }

    /**
     * <p> 功能描述：获取连续的天数 </p>
     * 
     * @author jiangyu
     * @date 2016年5月2日 上午10:56:23
     * @param dateList
     * @param patten
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static int getcontinueDates(Set<String> dateSet, String patten)
    {
        int count = 0;
        if (!CollectionUtil.isEmpty(dateSet))
        {
            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i <= TimeUtil.MAX_CONTINIOUS_DAYS; i++ )
            {
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_MONTH, -i);
                String tempTimeStr = TimeUtil.getTimeStr(calendar.getTime(), TimeUtil.PATTERN_DATE_1);
                if (TimeUtil.getTimeStr(new Date(), TimeUtil.PATTERN_DATE_1).equals(tempTimeStr) && dateSet.contains(tempTimeStr))
                {
                    ++count;
                }
                else
                {
                    if (i == 0)
                    {
                        continue;
                    }
                    if (!dateSet.contains(tempTimeStr))
                    {
                        break;
                    }
                    ++count;
                }
            }
        }
        return count;
    }

    /**
     * <p> 功能描述：根据用户生日计算年龄</p>
     * 
     * @author jiangyu
     * @date 2016年10月23日 下午3:09:23
     * @param birthday
     *            生日
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static int getAgeByBirthday(Date birthday)
    {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday))
        {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth)
        {
            if (monthNow == monthBirth)
            {
                if (dayOfMonthNow < dayOfMonthBirth)
                {
                    age-- ;
                }
            }
            else
            {
                age-- ;
            }
        }
        return age;
    }

    /**
     * <p> 功能描述：当前日期的提前N年</p>
     * @author  jiangyu
     * @date  2016年11月1日 下午1:33:11
     * @param unitValue 指定的年
     * @param beginTime 开始时间
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date someYearBeforeAssignDate(Integer unitValue, Date beginTime)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginTime);
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)-unitValue);
        return cal.getTime();
    }

    /**
     * <p> 功能描述：当前日期的提前N月</p>
     * @author  jiangyu
     * @date  2016年11月1日 下午1:33:17
     * @param unitValue 指定的月
     * @param beginTime 开始时间
     * @return 
     * @version v1.0
     * @since V1.0
     */
    public static Date someMonthBeforeAssignDate(Integer unitValue, Date beginTime)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginTime);
        cal.set(Calendar.MONDAY, cal.get(Calendar.MONDAY)-unitValue);
        return cal.getTime();
    }

    /**
     * <p> 功能描述：当前日期的提前N日</p>
     * @author  jiangyu
     * @date  2016年11月1日 下午1:33:22
     * @param unitValue 指定的天
     * @param beginTime 开始时间
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date someDayBeforeAssignDate(Integer unitValue, Date beginTime)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginTime);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-unitValue);
        return cal.getTime();
    }

    /**
     * <p> 功能描述：获取间隔时间的开始时间</p>
     * @author  jiangyu
     * @date  2016年12月14日 上午11:31:43
     * @param day 间隔的天数 
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static Date getIntervalDayBeginTime(int day)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}
