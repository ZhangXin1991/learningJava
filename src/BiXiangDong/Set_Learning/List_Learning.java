package BiXiangDong.Set_Learning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
List中的已知子接口
ListIterator<E>  列表迭代器
    它可以在迭代过程中完成对元素的操作
    构造方法:
        ListIterator<E> listIterator()  返回列表元素的列表迭代器(按适当顺序)
        ListIterator<E> listIterator(int index)从列表的指定位置开始
    - 1,添加
    - 2,获取
    - 3,修改
    - 4.删除
    注意: 只有在list集合具备该迭代功能, 其它集合无法在迭代中修改元素
    - 遍历:
        |- hasNext() 以正向遍历列表时, 如果列表迭代器有多个元素, 则返回true
        |- hasPrevious() 如果以逆向遍历列表, 列表迭代器有多个元素, 则返回true
        |- next() 返回列表中的下一个元素
        |- previous 返回列表中的前一个元素
XMLEventReader

List中开发中常用的已知实现类:
    - Vector(比较特殊, 几乎不用了)
        |- 内部是数组数据结构
        |- 是同步的, 线程安全的
        |- 增删, 查询都很慢......
    - ArrayList
        |- 内部是数组数据结构, 角标有序
        |- 是不同步的. 替代了Vector, 如果需要同步可以加锁
        |- 查询的速度很快
    - LinkedList
        |- 内部是连接列表(链表)数据结构, 有角标
        |- 是不同步的
        |- 增删元素的速度很快
最后: ArrayList(数组列表)替代Vector(向量)
      Iterator(迭代器)替代enumeration(枚举)
 */
public class List_Learning {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
//        show(list);


//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Object obj = iterator.next();
//            //  java.util.ConcurrentModificationException
//            //  在迭代器遍历的过程中是不可以修数据的
//            //  在迭代过程中不要使用集合操作元素, 容易出现异常
//            //  可以使用Iterator接口中的子接口ListIterator,
//            //  来完成在迭代过程中对元素进行更多的操作
//            if (obj.equals("abc2")) {
//                list.add("abc9");
//            } else
//                System.out.println("next: " + obj);
//        }
//        System.out.println(list);
        //  以上代码中的iterator无法在遍历中修改元素, 可以使用ListIterator接口
        ListIterator itlist = list.listIterator();
        while (itlist.hasNext()) {
            Object obj = itlist.next();
            if (obj.equals("abc2")) {
                itlist.add("abc9");
            }
            else
                System.out.println("next: " + obj);
                //  next: abc1
                //  next: abc3
                //  next: abc4
        }
        System.out.println(list);// [abc1, abc2, abc9, abc3, abc4]
    }

    public static void show(List list) {

        //  List取出元素的三种遍历方法:
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        for (Iterator it = list.iterator(); it.hasNext();) {
//            System.out.println(it.next());
//        }
//
//        for (int x = 0; x < list.size(); x++) {
//            System.out.println(x);
//        }
    }
}
