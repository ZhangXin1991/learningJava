package BiXiangDong.Thread_learning;


/*
wait()      :   线程等待方法
notify()    :   线程唤醒的方法(任意线程)
notifyAll() :   所有线程唤醒的方法
以上三种方法的使用测试
注意 :
    以上三种方法必须定义在synchronized代码块或同步函数中
    因为这些方法是用来操作线程状态的方法
    所以必须要明确到底操作的是哪个线程
 */


class ZiYuan
{
    public ZiYuan(){}
    public String name = "还没有";
    public String sex = "还不知道";
    public boolean flag = true;
    public boolean label = true;
}

class Input implements Runnable
{
    public ZiYuan z;
    public Input(ZiYuan z)
    {
        this.z = z;
    }
    public void run()
    {
        while (true)
        {
            synchronized (z)
            {
                if (z.label)
                {
                    try { z.wait(); }catch (InterruptedException e){}
                }
                if (z.flag)
                {
                    z.name = "旺财";
                    z.sex = "狗";
                    System.out.println("输入名字: " + z.name + " 输入动物: " + z.sex +
                            " 线程名称: " + Thread.currentThread().getName());
                    z.flag = false;
                }
                else
                {
                    z.name = "来福";
                    z.sex = "猫";
                    System.out.println("输入名字: " + z.name + " 输入动物: " + z.sex +
                            " 线程名称: " + Thread.currentThread().getName());
                    z.flag = true;
                }
                z.label = true;
                z.notify();
            }
        }
    }
}

class Output implements Runnable
{
    public ZiYuan z;
    public Output(ZiYuan z)
    {
        this.z = z;
    }
    public void run()
    {
        while (true)
        {
            synchronized (z)
            {
                if (! z.label)
                {
                    try { z.wait(); } catch (InterruptedException e){}
                }
                if (! z.flag)
                {
                    System.out.println("名字: " + z.name + " 动物: " + z.sex +
                    " 线程名称: " + Thread.currentThread().getName());
                    z.label = false;
                }
                else
                {
                    System.out.println("名字: " + z.name + " 动物: " + z.sex +
                    " 线程名称: " + Thread.currentThread().getName());
                    z.label = false;
                }
                z.label = false;
                z.notify();
            }
        }
    }
}

public class ThreadWaitNotifyTest {
    public static void main(String[] args) {
        ZiYuan z = new ZiYuan();

        Input in = new Input(z);
        Output out = new Output(z);

        Thread t = new Thread(in, "input");
        Thread t0 = new Thread(out, "output");

        t.start();
        t0.start();
    }

}
