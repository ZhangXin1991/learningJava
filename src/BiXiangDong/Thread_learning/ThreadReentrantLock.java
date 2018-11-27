package BiXiangDong.Thread_learning;


/*
JDK1.5之后可以用Lock接口中的子类来替代synchronized代码块
ReentrantLock   同步锁 相当于synchronized
    |- synchronized(obj){.....} 相当于 Lock lock = new ReentrantLock();lock.lock();.....lock.unlock();
    |- Object obj = new Object; 相当于 Condition con = lock.newCondition(); 可以创建多个锁;
Condition       监视器 相当于Object obj = new Object;
    |- obj.wait();      相当于 con.await();
    |- obj.notify();    相当于 con.signal();
    |- obj.notifyAll(); 相当于 con.signalAll();
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ziyuan917
{
    //  创建锁对象
    Lock lock = new ReentrantLock();
    //  通过已有的锁获取该锁上的监视器
    Condition con1 = lock.newCondition();   //  输出监视器
    Condition con2 = lock.newCondition();   //  输入监视器
    private String name;
    private String age;
    public boolean flag = false;
    private int x = 0;


    public void input(String name, String age)
    {
        this.name = name;
        this.age = age;
    }


    public void printNameAndAge()
    {
        System.out.println("姓名: " + name + ", 年龄: " + age);
    }


    public void inputzz()
    {
        while (true) {
//            synchronized (this)
//            {
            lock.lock();        //  同步开始
            try {
                while (this.flag)
//                { try { this.wait(); } catch (InterruptedException e) {} }
                { try { con2.await(); } catch (InterruptedException e) {} }

                if (x == 0)
                {
                    this.input("旺财", "10");
                } else {
                    this.input("来福啊", "12");
                }
                x = (x+1) % 2;
                this.flag = true;
//                this.notify();
//                con.signalAll();
                con1.signal();
            }
            finally {
                lock.unlock();  //  同步结束
            }

//            }
        }
    }
    public void outzz()
    {
        while (true)
        {
//            synchronized (this)
//            {
            lock.lock();
            try {
                while (!this.flag)
//                { try { this.wait(); } catch (InterruptedException e) {} }
                { try { con1.await(); } catch (InterruptedException e) {} }
                this.printNameAndAge();
                this.flag = false;
//                this.notify();
                con2.signal();
            }
            finally {
                lock.unlock();
            }

//            }
        }
    }
}


class input917 implements Runnable {
    private Ziyuan917 z;
//    private int x = 0;

    public input917(Ziyuan917 z) {
        this.z = z;
    }

    public void run() {
        z.inputzz();
//        while (true) {
//            synchronized (z)
//            {
//                while (z.flag)
//                { try { z.wait(); } catch (InterruptedException e) {} }
//                if (x == 0)
//                {
//                    z.input("旺财", "10");
//                } else {
//                    z.input("来福", "12");
//                }
//                x = (x+1) % 2;
//                z.flag = true;
//                z.notify();
//            }
//        }
//    }
    }
}




class out917 implements Runnable
{
    private Ziyuan917 z;
    public out917(Ziyuan917 z)
    {
        this.z = z;
    }

    public void run() {
        z.outzz();
    }
//        while (true)
//        {
//            synchronized (z)
//            {
//                while (!z.flag)
//                { try { z.wait(); } catch (InterruptedException e) {} }
//                z.printNameAndAge();
//                z.flag = false;
//                z.notify();
//            }
//        }
}



public class ThreadReentrantLock {
    public static void main(String[] args) {
        Ziyuan917 zz = new Ziyuan917();

        input917 input = new input917(zz);
        out917 output = new out917(zz);

        Thread t0 = new Thread(input);
        Thread t1 = new Thread(output);
        Thread t2 = new Thread(output);
        Thread t3 = new Thread(output);

        t0.start();
        t1.start();
        t2.start();
        t3.start();

//        input.input("wangcai" , "10");
    }
}
