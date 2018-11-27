package Cpre_java.lambda;

import jdk.jfr.Event;

import javax.swing.*;
import java.util.*;
import javax.swing.Timer;


/**
 * 演示如何在一个比较器和一个动作监听器中使用lambda表达式
 */
public class LambdaTest {
    public static void main(String[] args){
        //  创建一个String数组, 内容是九大行星
        String[] planets = new String[] {"mercury", "venus", "earth", "mars", "jupiter", "saturn",
                "uranus", "neptune"};

        System.out.println(Arrays.toString(planets));   //  输出字符串数组的方法
        System.out.println("sorted in dictionary order: 按字典顺序进行排序");
        Arrays.sort(planets);                           //  按字典顺序排序
        System.out.println(Arrays.toString(planets));
        System.out.println("sorted by length: 按长度排序");
        Arrays.sort(planets, (first, second) ->
                first.length() - second.length());      //  按字符串长度排序
        System.out.println(Arrays.toString(planets));


        //  method: Timer(时间, 行动事件)
        Timer t = new Timer(1000, event ->
                System.out.println("the time is " + new Date()));   //  lambda表达式
        t.start();


        JOptionPane.showMessageDialog(null, "quit program");
        System.exit(0);
    }

}
