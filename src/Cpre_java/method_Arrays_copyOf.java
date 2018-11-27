package Cpre_java;

import java.util.Arrays;

public class method_Arrays_copyOf {
    public static void main(String[] args){
        int[] lst1 = new int[] {1,2,3,4,5,6,7,8};

        //  将一个数组拷贝到另一个新数组 int[]
        // list2 = Arrays.copyOf(list1,list1.length());
        int[] lst2 = Arrays.copyOf(lst1, lst1.length);
        for (int a : lst2)
            System.out.print(a);
    }
}
