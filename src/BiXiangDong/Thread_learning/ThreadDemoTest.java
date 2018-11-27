package BiXiangDong.Thread_learning;


class Demo extends Thread
{
    private String name;
    Demo(String name)
    {
        super(name);    //  传入线程名称
        this.name = name;

    }


    public void run()       //  覆写Thread类中的run方法
    {
        show();
    }

    public void show()
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = -999999999; y < 999999999; y++)
            {

            }
            System.out.println(name + "......x=" + x + ", 当前线程名称: " + Thread.currentThread().getName());
        }
    }
}


public class ThreadDemoTest
{
    public static void main(String[] args) {
        Thread t1 = new Thread();   //  创建线程
        /*
        创建线程的目的是为了开启一条执行路径
        开启一条执行路径的目的是为了指定一部分代码能和其他的代码同时运行
        而运行的指定代码就是这个执行路径的任务;

        JVM创建的主线程的任务都定义在主函数当中, 而自定义的线程都在 run方法 中↓

        Thread类用于描述线程, 线程是需要任务的. 所以Thread类也有对任务的描述,
        而这个任务就通过Thread类中的run方法来体现. 也就是说 run方法 就是封装自定义线程运行任务的函数

        run方法中定义的就是线程要运行的任务代码

        开启线程是为了运行指定代码, 所以只有继承Thread类, 并覆写run方法, 将运行的方法定义在run方法中即可.
        */


        Demo d1 = new Demo("旺财");
        Demo d2 = new Demo("来福");

        d1.start();     //  启动线程
        d2.start();     //  启动线程
        //  Thread.currentThread()  获取当前进程对象
        System.out.println("呵呵" + ", 当前线程名称: " + Thread.currentThread().getName());
    }
}



