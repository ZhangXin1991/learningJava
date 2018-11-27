package BiXiangDong.API_Learning;

import java.util.Random;

/*
* Math 数学
*/
public class Math_Demo_Learning {
    public static void main(String[] args) {
        /*
        * Math : 提供了操作数学运算的方法. 都是静态的
        *
        * 常用的方法:
        *   - static double
        *       ceil(double a)
        *       返回最小的(最接近负无穷大)double值, 该值大于等于参数, 并等于某个整数
        *       简单的说就是返回大于参数的最小整数
        *   - static double
        *       floor(double a)
        *       返回最大的(最接近正无穷大)double值, 该值小于等于参数, 并等于某个整数
        *       简单地说就是返回小于参数的最大整数
        *   - static double
        *       round(double a)
        *       返回四舍五入的整数
        *   - static int
        *       max(int a, int b)
        *       返回两个整数之中较大的一个
        *   - static int
        *       min(int a, int b)
        *       返回两个整数之中较小的一个
        *       此方法有重载接接收long,float,double类型
        *   - static double
        *       pow(double a, double b)
        *       返回第一个参数的第二个参数次幂的值
        *       返回a的b次方
        *       特殊情况查API......
        *       如: 如果第二个参数为正0或负0, 那么结果为1.0
        *           如果第二个参数为1.0, 那么结果与第一个参数相同
        *           如果第二个参数为NaN, 那么结果为NaN
        *           ......
        *   - static double
        *       random()
        *       返回带正号的double值, 该值大于等于0.0 且小于1.0
        *       返回值是一个伪随机选择的数, 在该范围内(近似)均匀分布
        *       第一次调用该方法是, 它将创建一个新的伪随机数生成器,如下
        *       new java.util.Random
        *       之后, 新的伪随机数生成器可用于此方法的所有调用, 但不能用于其它地方
        *       此方法是完全同步的, 可允许用于多个线程使用而不出现错误,
        *       但是, 如果许多线程要以极高的速率生成伪随机数,
        *       那么可能会减少每个线程对拥有自己伪随机数生成器的征用
        *   -
        *
        *       
        */
        double d1 = Math.ceil(12.56);
        double d2 = Math.floor(12.56);
        double d3 = Math.round(12.56);
        sop("d1 = " + d1);
        sop("d1 = " + d2);
        sop("d1 = " + d3);

        double d = Math.pow(10, 2);//   10的2次方
        System.out.println(d);

//        Random random = new Random();//   不是Math类,这个是Random类..
        double random = Math.random();
        System.out.println(random);
    }

    private static void sop(String s) {
        System.out.println(s);
    }
}
