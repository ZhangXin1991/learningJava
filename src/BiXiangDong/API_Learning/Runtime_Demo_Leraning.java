package BiXiangDong.API_Learning;

import java.io.IOException;

/*
* Runtime 运行时
*/
public class Runtime_Demo_Leraning {
    public static void main(String[] args) {
        /*
        * Runtime:
        *   没有构造方法摘要, 说明该类不可创建对象
        *   又发现该类拥有非静态的方法, 说明该类应该提供静态的返回该类对象的方法
        *   而且只有一个, 说明Runtime类使用了单例设计模式
        */
        Runtime r = Runtime.getRuntime();
        //  execute : 执行
//        try {     //  运行notepad 记事本
//            r.exec("C:\\Program Files (x86)" +
//                    "\\Tencent\\QQ\\Bin\\QQScLauncher.exe");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            //  运行notepad 记事本  再用记事本解析ideA快捷键.txt
            Process p = r.exec("notepad.exe C:\\" +
                    "Users\\65404\\Desktop\\IdeA快捷键.txt" );
            //  线程睡眠(冻结)5000毫秒
            Thread.sleep(5000);
            //  杀死该子进程
            p.destroy();
            //  捕捉IO异常或中断异常
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
