package BiXiangDong.Thread_learning;

/*
多线程中 synchronized嵌套中的开关冲突
 */

class Test implements Runnable
{
    private boolean flag;
    public Test(boolean flag)
    {
        this.flag = flag;
    }


    public void run()
    {
        if (flag)
        {
            synchronized (Mylock.locka)
            {
                System.out.println("locka if : " + Thread.currentThread().getName());
                synchronized (Mylock.lockb)
                {
                    System.out.println("lockb if : " + Thread.currentThread().getName());
                }
            }
        }
        else
        {
            synchronized (Mylock.lockb)
            {
                System.out.println("lockb else : " + Thread.currentThread().getName());
                synchronized (Mylock.locka)
                {
                    System.out.println("locka else : " + Thread.currentThread().getName());
                }
            }
        }
    }
}

class Mylock
{
    public static final Object locka = new Object();
    public static final Object lockb = new Object();
}

public class SynchronizedLockClash {
    public static void main(String[] args) {
        Test t1 = new Test(true);
        Test t2 = new Test(false);
        Thread a = new Thread(t1, "旺财");
        Thread b = new Thread(t2, "来福");
        a.start();
        b.start();
    }
}
