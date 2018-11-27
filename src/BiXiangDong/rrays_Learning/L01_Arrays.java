package BiXiangDong.rrays_Learning;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class L01_Arrays {
    public static void main(String[] args) {


    }

    public void sumnums(int i, int ...nums) {
        int n = 0;
        for (int a : nums) {
            n=n+a;
        }
        System.out.println(n+i);
    }

    @Test
    public void test() {
        sumnums(1, 2, 3, 4, 5, 6);

    }

    @Test
    public void bb() {
        List list = Arrays.asList("1", "2", "3");
        System.out.println(list);

        String arr[] = {"1","2","3","4"};
        list = Arrays.asList(arr);
        System.out.println(list);

        int nums[] = {1, 2, 3, 4, 5};
        list = Arrays.asList(nums);
        System.out.println(list);

        Integer numss[] = {1, 2, 3, 4, 5};
        list = Arrays.asList(numss);
        System.out.println(list);

    }
}
