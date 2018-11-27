package Cpre_java;
/*
抽取彩票的模型?
 */

import java.util.Arrays;
import java.util.Scanner;

public class method_Math_random {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println("输入最大值: ");
        int n = in.nextInt();   //  输入数字

        System.out.println("输入抽取次数: ");
        int k = in.nextInt();   // 输入数字

        int[] numbers = new int[n]; //  建立这个数字长度数组
        for (int i = 0; i < numbers.length; i ++) numbers[i] = i + 1;   // 从数字1开始填入这个数组

        int[] result = new int[k];  // 建立保存抽取数字的数组
        for (int i = 0; i < result.length; i ++) {
            int rd = (int) (Math.random() * n); //  每次循环都产生一个从0~n的随机数字
            result[i] = rd; //  将抽取出的数字保存
            numbers[rd] = numbers[n - 1]; // 用numbers的最后一位数字替换抽取出的数字的位置
            n --;   // 把最后一位数字"减掉", 保证抽取numbers中的数字时不会出现重复数字
//            for (int b : numbers) System.out.print(b + "\t"); //  查看每次抽取后的numbers list
//            System.out.println(); //  打印个换行...
        }

//        Arrays.sort(result);    //  对保存抽取数字的数组进行排序
        for (int r : result) System.out.print(r + "\t");
    }
}
