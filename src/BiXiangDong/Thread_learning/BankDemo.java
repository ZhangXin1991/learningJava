package BiXiangDong.Thread_learning;

/*
需求 :
    储户, 两个, 每个都去银行存钱, 每次存100, 共存三次
 */


class Bank {
    private int sum;
//    Object obj0 = new Object();   //  使用同步代码块
//    public void add(int num){     //  使用同步代码块
    public synchronized void add(int num){  //  使用同步函数
        /*  此处会出现线程安全隐患
            因为sum是共享数据, 每次sum进行运算后和打印sum是有间隙的, 所以有可能会出现sum运算后cpu切换线程
        从而导致相邻的打印出现相同的状况
        例如 :
            线程一 this.sum = sum + num;  // sum(300) = 200 + 100 此时sum 的值变为 300
            线程二 this.sum = sum + num;  // sum(400) = 300 + 100 此时sum 的值变为 400
            线程二 print(sum = 400)
            线程一 print(sum = 400)
        */
//        synchronized (obj0)
//        {
//            this.sum = sum + num;
//            try {
//                Thread.sleep(10);
//            }
//            catch (InterruptedException e)
//            {
//            }
//            System.out.println("银行当前拥有: " + this.sum + " 线程名称: " + Thread.currentThread().getName());
//        }
        this.sum = sum + num;
        try {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
            }
        System.out.println("银行当前拥有: " + this.sum + " 线程名称: " + Thread.currentThread().getName());
    }
}

class Cus implements Runnable
{
    private Bank b = new Bank();
    Object obj1 = new Object();

    public void run()
    {
//        synchronized (obj1){
        //  此处非线程同步问题所在
        //  因为循环判断非共享数据, 故: 每个线程对象都有自己的for循环判断
            for (int x = 0; x < 100; x ++)
            {
                b.add(100);
            }
//        }
    }
}


public class BankDemo {
    public static void main(String[] args) {
        Cus c = new Cus();
        Thread t1 = new Thread(c, "旺财");
        Thread t2 = new Thread(c, "来福");
        t1.start();
        t2.start();

    }
}
