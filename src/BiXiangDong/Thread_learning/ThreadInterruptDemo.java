package BiXiangDong.Thread_learning;

/*
多线程结束方法:
1, run()方法结束
2, run()方法中都会有while循环, 可以用标记方法让while循环结束, 然后run方法结束;
    但是如果多条同步的线程中有处于中断状态(sleep, wait, join)就会被遗漏, 导致无法立刻结束
3, 这时可以使用interrupt()方法
    -  如果线程处于中断状态(sleep, wait, join), 则可以用interrupt()方法强制线程恢复到运行状态中来,
    让线程具备cpu执行权.
    -  此方法会发生InterruptException异常, 记得要处理.
4, setDaemon(true)方法, 守护线程(或称为后台线程, 联合线程)
    -  此方法会在除当前线程之外所有线程都结束之后结束当前线程
    -  此方法必须在start();前使用 !

join()方法
    -  t0.join();方法会使main线程等待t0线程, 直到t0线程运行结束main线程才会继续运行
        此方法一般用于t0线程临时加入进来运行, 临时加入一个线程运算时, 可以使用join();方法
 */


class HuanCun implements Runnable
{
    public boolean flag = true;

    public void setflag()
    {
        flag = false;
    }

    public synchronized void run()
    {
        while (flag)
        {
            try { this.wait(); }
            catch (InterruptedException e)
            {
                System.out.println(Thread.currentThread().getName() + "__________ 线程wait()!");
                this.setflag();
            }

            System.out.println("线程名称: " + Thread.currentThread().getName());
        }
    }
}


public class ThreadInterruptDemo {
    public static void main(String[] args) {
        HuanCun h = new HuanCun();
        Thread t0 = new Thread(h);
        Thread t1 = new Thread(h);
        t0.start();

        //  join();方法会使main线程等待t0线程, 直到t0线程运行结束main线程才会继续运行
        //  此方法一般用于t0线程临时加入进来运行, 临时加入一个线程运算时, 可以使用join();方法
        try { t0.join(); } catch (InterruptedException e){}

        t1.setDaemon(true);     //  第四种结束方法, setDaemon(true);必须在start();前声明.
        t1.start();

        int num = 0;
        for (;;)
        {
            num ++;
            System.out.println("线程名称: " + Thread.currentThread().getName());

            if (num > 31)
            {
                System.out.println(Thread.currentThread().getName() + " speck over!");
                t0.interrupt();
//                t1.interrupt();
                break;
            }
        }
    }
}
