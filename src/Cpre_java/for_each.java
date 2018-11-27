package Cpre_java;


import java.util.Arrays;

public class for_each {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 7, 8, 9};

        for (int b : a)
            System.out.println(b);

        // Arrays.toString(int[] variable) 方法.  返回打印出一个list
        System.out.println(Arrays.toString(a));


    }
}
