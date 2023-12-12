package utils;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
@Slf4j
public class DateUtils {

    /**
     * 将日期添加指定天数
     *
     * @param date   日期
     * @param amount 天数
     * @return 日期
     */
    public static Date addDay(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, amount);
        return c.getTime();
    }

    /**
     * 获取指定日期的开始时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date getDateStart(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(DateUtil.format(date, "yyyy-MM-dd") + " 00:00:00");
        } catch (ParseException e) {
            log.error("获取指定日期的开始时间异常", e);
        }
        return date;
    }

    /**
     * 获取指定日期的结束时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date getDateEnd(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(DateUtil.format(date, "yyyy-MM-dd") + " 23:59:59");
        } catch (ParseException e) {
            log.error("获取指定日期的结束时间异常", e);
        }
        return date;
    }

}
