package BiXiangDong.Set_Learning;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
练习:
    对字符串进行长度排序

思路:
    因为String类型有自己的compareTo()方法, 现在还不知道如何对其更改
    所以直接写一个比较器传入创建的TreeSet集合框架中
 */
public class Test_TreeList {

    public static void main(String[] args) {


        TreeSet treeSet = new TreeSet(new ComparatorByStringLength());

        treeSet.add("1234567");
        treeSet.add("1234");
        treeSet.add("12345678");
        treeSet.add("1234567890");
        treeSet.add("asdlkfj");
        treeSet.add("asdlkfj31");
        treeSet.add("asdlkfg");

        //  输出:
        for (Iterator iterator = treeSet.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}


class ComparatorByStringLength implements Comparator {

    private String s1;
    private String s2;
    @Override
    public int compare(Object o1, Object o2) {

        if (o2 instanceof String) {
            s1 = (String) o1;
            s2 = (String) o2;
        }
        int temp = s1.length() - s2.length();

        //  如果temp==0 (长度相等) 就返回1(顺延), 否则就返回temp的值
        return temp==0? s1.compareTo(s2) : temp;
    }
}
