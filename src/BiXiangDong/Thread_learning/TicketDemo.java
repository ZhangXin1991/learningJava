package BiXiangDong.Thread_learning;

/**
 * 卖票....
 * 共一百张...
 * 四个窗口卖......
 * ......
 */
class Ticket implements Runnable
{
    private int num = 100;
    Object obj = new Object();
    //    private static int num = 100;

    public void sale()
    {
        while (true)
        {
            //  为了保证线程的安全性, 下面的多线程任务代码将使用同步代码块 :
            //  synchronized(对象){需要被同步的代码}
            synchronized (obj)
            {
                if (num > 0)
                {
                    try {
                        //  调用Thread.sleep(millis)方法, 使即将调用一下代码的对象的线程任务冻结1000毫秒
                        //  该方法中具有两种异常:
                        //  一, IllegalArgumentException
                        //      |- 如果millis是负数
                        //  二, InterruptedException
                        //      |- 如果任何线程中断当前线程, 当抛出此异常时, 当前线程的终端状态将被清除
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e)
                    {
                    }
                    System.out.println(Thread.currentThread().getName() + "......" + num--);

                }
                if (num <= 0)
                {
                    break;
                }
            }
        }
    }

    public void run()
    {
        this.sale();
    }
}

public class TicketDemo {
    public static void main(String[] args) {
        //  创建一个线程任务对象
        Ticket t = new Ticket();

        //  创建四个线程
        Thread thread1 = new Thread(t, "窗口1");
        Thread thread2 = new Thread(t, "窗口2");
        Thread thread3 = new Thread(t, "窗口3");
        Thread thread4 = new Thread(t, "窗口4");

        //  开启四个线程
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        /*
        //  创建四个线程任务对象
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();
        //  每个对象创建一个线程
        Thread thread1 = new Thread(t1, "窗口1");
        Thread thread2 = new Thread(t2, "窗口2");
        Thread thread3 = new Thread(t3, "窗口3");
        Thread thread4 = new Thread(t4, "窗口4");
        //  开启这四个线程
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        */
    }
}
