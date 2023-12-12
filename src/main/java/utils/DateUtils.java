package utils;

import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {

    /**
     * 将日期添加指定天数
     * @param date
     * @param amount
     * @return
     */
    public static Date addDay(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, amount);
        return c.getTime();
    }

    /**
     * 获取指定日期的开始时间
     * @param date
     * @return
     */
    public static Date getDateStart(Date date) {
        if(date==null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date= sdf.parse(DateUtil.format(date, "yyyy-MM-dd")+" 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     *  获取指定日期的结束时间
     * @param date
     * @return
     */
    public static Date getDateEnd(Date date) {
        if(date==null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date= sdf.parse(DateUtil.format(date, "yyyy-MM-dd") +" 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
