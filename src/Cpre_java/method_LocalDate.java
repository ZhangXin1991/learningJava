package Cpre_java;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class method_LocalDate {
    public static void main(String[] args){
        System.out.println(LocalDate.now());    //  2018-08-14  打印当前日期

        //  提供年月日来构造对应一个特定的日期, 并保存在一个对象变量中:
        LocalDate newYearEve = LocalDate.of(1999, 12, 31);
        //  有了LocalDate对象, 可以使用方法:getYear, getMonthValue, getDayOfMonth方法
        int year = newYearEve.getYear();    //  1999
        int month = newYearEve.getMonthValue(); //  12
        int day = newYearEve.getDayOfMonth();   //  31
        System.out.println(year+"\n"+month+"\n"+day);   //  把这三变量打印出来

        //  plusDays方法会得到一个新的LocalDate对象, 它是当前LocalDate对象加上指定天数的方法:
        LocalDate plusnewYearEve = newYearEve.plusDays(365);    //  1999-12-31加上个365天看看
        System.out.println(plusnewYearEve); //  2000-12-30  结果


        //  以下是打印当前月份日历的程序
        LocalDate date = LocalDate.now();           //  初始化当前时间
        int month0 = date.getMonthValue();          //  获得当前 月
        int today = date.getDayOfMonth();           //  获得当前 日

        date = date.minusDays(today - 1);           //  获得这个月的1号的日期
//        System.out.println("ccc" + date);                                         // 查看date的值
        DayOfWeek weekday = date.getDayOfWeek();    //  获得这个月的开始日期的星期值
//        System.out.println("ccc" + weekday.toString());                           // 查看weekday的值
        int value = weekday.getValue();             //  把这个星期值转换成int类型
//        System.out.println("ccc" + value);                                        //  查看value的值
        System.out.println("mon tue wed thu fri sat sun");//打印个日历的表头
        for (int i = 1; i < value; i ++)            //  根据这个星期值来循环打印日历的空白
            System.out.print("    ");
        while (date.getMonthValue() == month0){     //  如果date的月份 == 当前月份
            System.out.printf("%3d", date.getDayOfMonth());//打印 date的 日
            if (date.getDayOfMonth() != today)      //  如果date的 日 == 今天
                System.out.print(" ");              //  打印 *
            else
                System.out.print("*");              //  否则打印" "
            date = date.plusDays(1);                //  date + 1
            if (date.getDayOfWeek().getValue() == 1) System.out.println();//  如果date的星期的int类型的值=1打印换行
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();//  这个月的日期打完之后,如果!=1则打印换行
    }
}



