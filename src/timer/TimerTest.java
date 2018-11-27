package timer;

/**
 * Core Java    6.2.1   223 page
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTest {
    public static void main(String[] args){

        //  请看下面ActionListener接口, listener = a class as void method
        ActionListener listener = new TimePrinter();

        Timer t = new Timer(10000, listener);   //  定时器;    每隔10秒执行一次listener
        t.start();  //  计时器开始

        //  弹窗方法
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);     //  计时器结束

    }
}



class TimePrinter implements ActionListener{        //  action Listener : 动作监听器
    //  ActionListener的接口
    public void actionPerformed(ActionEvent event){ //  event : 事件, action : 动作......
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();         //  toolkit : 工具包   beep : 哔哔响......

    }
}
