package BiXiangDong.API_Learning;

import java.util.Calendar;

/*
* Calendar  日历
* 常用方法:
*   - get   获取 年/月/日/周
*       int
*       calendar.get(Calendar.YEAR/MOTH/DAY/WEEK)
*   - set   设置 年/月/日/时间/日期
*       Calendar
*       calendar.set(int year, int moth, int date, int hours...)
*   - add   增加 年/月/日....
*       Calendar
*       calendar.add(int field, int amount)
* */
public class Calendar_Demo_Learning {
    public static void main(String[] args) {
        //  创建日历对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        //  获取年月日周
        showYMDW(calendar);

        //  设置日期
        calendar.set(2011, 3, 20);
        //  在原有日期上增加日期
        //  增加2年
        calendar.add(Calendar.YEAR, 2);
        showYMDW(calendar);

        /*
        * 练习:
        * 获取任意年的二月有多少天
        * */
        int year = 2018;
        showMOTH2Day(year);
    }

    /**
     * 获取任意年的二月最后一天的日期
     * @param year 接收int类型 任意年yyyy
     */
    private static void showMOTH2Day(int year) {
        //  获取日历对象
        Calendar calendar = Calendar.getInstance();
        //  设置为任意年的3月1日对象
        calendar.set(year, 2, 1);
        //  以 日 为单位, 增加-1 , 结果为任意年的2月的最后一天的日期
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        //  用自定义方法打印日期
        showYMDW(calendar);
    }

    /**
     * @param calendar 传入日历对象
     * 打印日期 : 年月日周
     */
    private static void showYMDW(Calendar calendar) {

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        int week = calendar.get(Calendar.DAY_OF_WEEK);// 1
        //  输出日期
        System.out.println(year+"年"+month+"月"+day+"日"+" "+
                getWeek(week));
    }

    private static String getWeek(int i) {
        //  使用查表法....
        String[] weeks = {"周日", "周一", "周二","周三","周四","周五"
                ,"周六"};

        return weeks[i-1];
    }
}
