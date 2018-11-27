package BiXiangDong.API_Learning;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* Date       日期
* DateFormat 日期格式化
* Calendar   日历
*/
public class Date_Demo_Learning {
    public static void main(String[] args) throws ParseException {
        /*
         * 日期对象和毫秒值之间的转换
         *   毫秒值-->日期对象:
         *       - 通过Date对象的构造方法new Date(timeMillis);
         *       - 通过setTime设置
         *     因为可以通过Date对象的方法对该日期中的各个字段(年月日等)进行操作
         *   日期对象-->毫秒值:
         *       - 通过getTime方法
         *     因为可以通过具体的数值进行运算
         */
//        method_demo1();

        /*
        * 将系统时间转换成需要的格式
        * 由于Date类大部分方法已经过时
        * 所以使用DateFormat类
        *   - java.text.DateFormat
        * 此类是一个抽象类, 无法直接创建对象
        * 要格式化一个当前语言环境下的日期, 可使用某个静态工厂方法:
        *   如: myString = DateFormat.getDateInstance().format(myDate);
        */
        /*
        * 对日期对象进行格式化:
        *   将日期对象-->日期格式的字符串
        *       - 使用的是DateFormat类中的format方法
        *   将日期格式的字符串-->日期对象
        *       - 使用的是DateFormat类中的parse()方法
        */
//        method_demo2();
        method_demo4();

        //  如果风格是自定一个如何解决呢?
        method_demo3();
        /*
        * 练习:
        *   "2012-3-17"到"2012-4-6"
        *   间隔多少天?
        * 两日期间隔日的获取方法:
        * 思路:
        *   两个日期进行减法运算
        *   两个日期必须转换成可进行减法运算的数据
        *   可以转换成毫秒值进行运算
        *   通过date对象
        *   1, 将日期格式的字符串转换成Date对象
        *   2, 将Date对象转换成毫秒值
        *   3, 进行减法运算, 再转换成天数*/
        String date_test1 = "2012-3-17";
        String date_test2 = "2012-4-6";
        date_test(date_test1, date_test2);
    }

    /**
     * 两日期间隔日的获取方法
     * @param date_test1 日期1
     * @param date_test2 日期2
     * @throws ParseException 格式化日期转换失败
     */
    private static void date_test(String date_test1, String date_test2) throws ParseException {
//        DateFormat dateFormat = DateFormat.getDateInstance();
//        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //  上两行的等价代码:
        //  创建日期格式化对象:
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //  将两个字符串参数转换成日期格式,添加抛出异常;
        Date date1 = dateFormat.parse(date_test1);
        Date date2 = dateFormat.parse(date_test2);
        //  将两个日期格式的数据转换成毫秒值
        long millis1 = date1.getTime();
        long millis2 = date2.getTime();
        //  取两个毫秒值的差 temp
        long millistemp = Math.abs(millis1 - millis2);
//        System.out.println(millistemp);
        //  将temp单位 毫秒 转换为 天
        long day = millistemp/1000/60/60/24;
        System.out.println(day);
    }

    private static void method_demo1() {
        //  current : 当前
        //  millis  : 毫秒
        //  获取当前系统时间毫秒值
        long time = System.currentTimeMillis();
        System.out.println(time);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //  当前星期,月份,日期,时间,时区,年份
        //  将当前日期时间date封装成日期对象
        Date date = new Date();
        System.out.println(date);
        //  将指定毫秒值封装成日期对象
        Date date1 = new Date(time);
        System.out.println(date1);
        date.setTime(time);
        long ll = date.getTime();
        System.out.println(ll);

    }
    private static void method_demo2() {
        //  创建当前时间对象
        Date date = new Date();
        //  获取日期格式器对象
        //  该格式器具备默认语言环境的默认格式化风格
        DateFormat dateFormat = DateFormat.getDateInstance();
        String str_date = dateFormat.format(date);
        System.out.println(str_date);// 2018年10月20日
        //  非默认格式可以传入参数 FULL LONG 等可以指定风格
        DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.FULL);
        String str_date2 = dateFormat2.format(date);
        System.out.println(str_date2);//2018年10月20日星期六

        //  获取日期时间格式器对象
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
        String str_date1 = dateFormat.format(date);
        System.out.println(str_date1);
        //默认(无参数传入): 2018年10月20日 下午9:02:27
        //传入DateFormat.FULL参数: 2018年10月20日星期六 中国标准时间 下午9:09:22
    }

    private static void method_demo4() throws ParseException {
        //  创建日期字符串对象
        String string_date = "2018-4-12";
        //  创建自定义日期格式器对象
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //  解析日期字符串对象
        Date date = dateFormat.parse(string_date);
        System.out.println(date);//Thu Apr 12 00:00:00 CST 2018

    }
    private static void method_demo3() {
        /*
        * 对日期对象进行自定义格式化
        *   子类SimpleDateFormat类
        * */

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd");
        String string_date = dateFormat.format(date);
        System.out.println(string_date);//  2018--10--20


    }

}
