package com.li.pc.lutils.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * author   ：mo
 * data     ：2016/10/11
 * time     ：17:48
 * function : 日期工具类
 */
public class UtilsDate {
    public static String[] months = {"Jan", "Feb", "Mar", "Apr", "May ", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static String[] monthNumber = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

    private UtilsDate() {
        throw new UnsupportedOperationException("ToastUtil cannot be instantiated");
    }

    /**
     * 自定义获取当前日期
     * yyyy-MM-dd hh:mm:ss
     *
     * @return
     */
    public static String getNowData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat(data);
        String date = sdf.format(new Date());
        return date;
    }

    /**
     * 获取当前月份
     * yyyy-MM-dd hh:mm:ss
     *
     * @return
     */
    public static String getNowMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String date = sdf.format(new Date());
        return date;
    }

    /**
     * 获取当前年份
     * yyyy-MM-dd hh:mm:ss
     *
     * @return
     */
    public static String getNowYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String date = sdf.format(new Date());
        return date;
    }

    /**
     *输入时间戳,返回所要求的的正常时期
     *
     * @param time；时间戳
     * @param type；yyyy-MM-dd-HH-mm-ss；输出日期格式（"2014年06月14日16时09分00秒"）
     * @return
     */
    public static String timeStampToData(String time, String type) {
        SimpleDateFormat sdr = new SimpleDateFormat(type);
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        return sdr.format(new Date(i * 1000L));
    }

    /**
     * 将给定的时间去掉“-”，并转化为int
     *
     * @param date 格式为2016-10-14字符串
     * @return
     */
    public static int dateToInt(String date) {
        String str = date.replaceAll("-", "");
        return Integer.parseInt(str);
    }

    /**
     *  在一个日期集合中找到距离指定日期最近的一天。并且这一天为指定日期之前的日期
     * 2016-10-14
     * @param listDate
     * @param date
     * @return
     */
    public static String getRecentDate(List<String> listDate, String date){//arr待比较的数组，date为给定的时间
        int input=dateToInt(date);
        int min= input- dateToInt(listDate.get(0));//假设第0个时间离给定时间最近
        int index=0;
        for(int i=1;i<listDate.size();i++){
            if((input-dateToInt(listDate.get(i))>=0)&&(input-dateToInt(listDate.get(i))<min)){//如果时间在给定时间之前，并且与给定时间的距离小于min,则该时间差为min
                min=input-dateToInt(listDate.get(i));
                index=i;
            }
        }
       return  listDate.get(index);
    }
    /**
     * 把秒转换成当前时间
     *
     * @param miao
     * @return
     */
    public static String getformatDateFrommill(Long miao) {
        Date d = new Date(miao * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(d);
    }
    /**
     * 输入时间戳变星期
     *
     * @param time
     * @return
     */
    public static String timeStampToWeek(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        Date date = null;
        int mydate = 0;
        String week = null;
        try {
            date = sdr.parse(times);
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            mydate = cd.get(Calendar.DAY_OF_WEEK);
            // 获取指定日期转换成星期几
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (mydate == 1) {
            week = "周日";
        } else if (mydate == 2) {
            week = "周一";
        } else if (mydate == 3) {
            week = "周二";
        } else if (mydate == 4) {
            week = "周三";
        } else if (mydate == 5) {
            week = "周四";
        } else if (mydate == 6) {
            week = "周五";
        } else if (mydate == 7) {
            week = "周六";
        }
        return week;
    }
    /**
     * 根据传入的String 时间戳判定是周几
     */
    public static String getWeekFromTimeMill(String time) {
        Long longtime = Long.parseLong(time);
        Date d = new Date(longtime * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
        }
        return "";

    }
}
