package BiXiangDong.Thread_learning;


/*
多线程中的单利设计模式
 */


class Single0   //  单例设计模式
{
    private static final Single0 s0 = new Single0();    //  创建一个静态不可变私有化的Single类型的 s0......
    private Single0(){}                     //  私有化构造方法, 只能在该类内部实例化该类, 外部外发创建实例对象

    public static Single0 getInstance()     //  s0 的获取方法
    {
        return s0;
    }
}

class Single1   //  延迟加载单例设计模式
{
    private static Single1 s1 = null;       //  创建一个空的Single1类 s1......
    private Single1(){}                     //  私有化构造方法, 只能在该类内部实例化该类, 外部外发创建实例对象

    public static Single1 getInstance()     //  s1 的获取方法
    {
        if (s1 == null)                     //  如果s1为空, 则创建一个Single1类对象
            s1 = new Single1();
        return s1;                          //  返回Single1类的实例化对象 s1
    }

}

class Single2   //  延迟加载单例设计模式
{
    private static Single2 s2 = null;       //  创建一个空的Single2类 s2......
    private Single2(){}                     //  私有化构造方法, 只能在该类内部实例化该类, 外部外发创建实例对象

    public static synchronized Single2 getInstance()
    /*
    s2 的获取方法, 由于此方法是静态同步函数, 每个线程都要经过synchronized的开关判断, 故, 浪费系统资源
     */
    {
        if (s2 == null)                     //  如果s2为空, 则创建一个Single2类对象
            s2 = new Single2();
        return s2;                          //  返回Single2类的实例化对象 s2
    }

}

class Single3   //  延迟加载单例设计模式
{
    private static Single3 s3 = null;       //  创建一个空的Single3类 s3......
    private Single3(){}                     //  私有化构造方法, 只能在该类内部实例化该类, 外部外发创建实例对象

    public static Single3 getInstance()     //  s3 的获取方法
    {
        if (s3 == null)                     //  为避免每个线程都要经过同步代码块判断, 所以增加if判断语句
        {
            synchronized (Single3.class)    //  同步代码块, 由于getInstance方法是静态方法, 故, Single3.class
            {
                if (s3 == null)             //  如果s3为空, 则创建一个Single3类对象
                    s3 = new Single3();
                return s3;                  //  返回Single3类的实例化对象 s3
            }
        }
        else return s3;                     //  直接返回s3
    }

}

public class SingleDemo {
    public static void main(String[] args) {

    }
}
