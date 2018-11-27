package BiXiangDong.Thread_learning;


class Demo1 implements Runnable
{
    private String name;
    Demo1(String name)
    {
        this.name = name;
    }

    //  实现Runnable接口, 覆盖run方法
    public void run()
    {
        show();
    }

    public void show()
    {
        for (int x = 0; x < 9; x++)
        {
            for (int y = -999999999; y < 999999999; y++)
            {
            }
            System.out.println(name + "......" + x + "  线程名称: " + Thread.currentThread().getName());
        }
    }
}


public class ThreadDemoTest2 {
    public static void main(String[] args) {
        Demo1 d1 = new Demo1("旺财");
        Demo1 d2 = new Demo1("来福");

        //  Thread类的构造方法: Thread(带有Runnable接口的对象)
        //  Thread类的构造方法: Thread(带有Runnable接口的对象 ,String name)
        Thread t1 = new Thread(d1, "旺财");
        Thread t2 = new Thread(d2, "来福");
        t1.start();
        t2.start();
    }
}
