package methods;

/**
 * 这个程序展示了如何通过反射调用方法
 * Core Java  5.7.6     page 207
 * square : 正方型
 * sqrt : 平方
 */

import java.lang.reflect.Method;

public class MethodTableTest {
    public static void main(String[] args) throws Exception{
        //  获取square和sqrt方法的方法指针
        Method square = MethodTableTest.class.getMethod("square", double.class);
//        Method sqrt = MethodTableTest.class.getMethod("sqrt", double.class);

        //  打印 x 和 y 的 值表格
        printTable(1, 10, 10, square);
//        printTable(1, 10, 10, sqrt);
    }

    /**
     * 返回一个数字的平方
     * @param x 一个数字
     * @return x 的平方
     */

    public static double square(double x){
        return x * x;
    }

    /**
     * 打印一张带有 x 和 y值 的表格
     * @param from  x 的下限
     * @param to    x 的上限
     * @param n     表格中的行数
     * @param f     具有双参数和双返回值的方法
     */
    public static void printTable(double from, double to, int n, Method f){
        //  print out the method as table header
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        for (double x = from; x <= to; x += dx){
            try {
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            }
            catch (Exception e){
                e.printStackTrace();    //  打印 跟踪堆栈
            }
        }
    }
}



