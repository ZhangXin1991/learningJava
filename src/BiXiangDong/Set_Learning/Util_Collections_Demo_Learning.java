package BiXiangDong.Set_Learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
  Collections
  这是一个集合框架的工具类
  这个类中的方法都是static的
  java.lang.Object
    |-  java.util.Collections

  特点:
    此类玩全由再collection上进行操作或返回collection的静态方法组成.
    它包含在collection上操作的多态算法, 即"包装器"
    包装器返回由指定collection支持的新collection, 以及少数其它内容
  注意:
    如果此类的方法所提供的collection或类对象为null, 则抛出NullPointerException

  类方法:
    -   <T extends Comparable<? super T>
        Collections.sort(List<T> list);
        根据元素的自然顺序对指定列表按升序进行排序
    -   <T extends Comparable<? super T>
        T类型  继承或实现Comparable<? 继承 T类>
    -   static <T> Comparator<T>
        Collections.reverseOrder(Comparator<T> cmp)
        返回一个比较器,它强制比较器逆序
    -   static <T> boolean
        Collections.replaceAll(List<T> list, T oldValue, T newValue)
        将列表中一个指定的值的所有都替换成另一个
    -   static <T> List<T>
        synchronizedList(List<T> list)
        返回由指定列表支持的同步(线程安全)列表
        synchronizedSet(Set<T> set)
        返回由指定集合支持的同步(线程安全)集合
        synchronizedMap(Map<K,V> map)
        返回由指定映射支持的同步(线程安全)映射
        synchronizedCollection(Collection<T> c)
        返回由指定collection支持的同步(线程安全)collection


*/
public class Util_Collections_Demo_Learning {
    public static void main(String[] args) {
        demo_1();
    }

    public static void demo_1() {
        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("abwc");
        list.add("abwc");
        list.add("abfc");
        list.add("abcb");
        System.out.println(list);
        //  对list集合进行指定顺序的排序
//        Collections.sort(list);
        mySort(list);
        System.out.println(list);

    }

    public static <T extends Comparable<? super T>> void mySort(List<T> list) {
        for (int i=0; i<list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
//                    T temp = list.get(i);
//                    list.set(i, list.get(j));
//                    list.set(j, temp);
                    Collections.swap(list, i, j);// 上三行的等价代码
                }
            }
        }
    }
}

