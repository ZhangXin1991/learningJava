package Cpre_java;

import java.util.Date;

public class method_Date {
    public static void main(String[] args){

        // 星期/月/日/小时:分钟:秒/中央时区/年  例如: Mon Aug 13 23:26:57 CST 2018
        System.out.println(new Date());     //  实例化一个Date() 并传递给system.out.println()方法
        String date = new Date().toString();//  将Date() 实例化 并 转换成字符串 赋值给 字符串类型的 变量date
        System.out.println(date);           //  打印 字符串类型的变量 date

        Date date1 = new Date();            //  将Date() 实例化 并 赋值给 Date类型的 变量date1
        System.out.println(date1);          //  打印 Date类型的变量 date1

        Date date2 ;                        //  声明 Date类型 的 对象 名为date2, 让date2 可以引用Date类型的对象;
        date2 = new Date();                 //  实例化 date2, 让date2引用 new Date();
        String s = date2.toString();        //  声明一个String类型的变量s 把Date类型的date2转换成String类型赋值给变量s

        String str = new Date().toString(); //  声明一个String类型的变量str,初始化Date 然后转换成String类型赋值给str
        System.out.println(str);

    }
}
