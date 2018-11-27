package BiXiangDong.Set_Learning;


import java.util.ArrayList;
import java.util.List;


/*

Collection
    |- List : 有序(存入和取出的顺序一致), 元素都有索引(角标), 元素可重复

    |- Set  : 无序(有可能会有序), 元素不可以重复


List 接口: 特有的常见方法:
    - 有一个共性特点就是可以操作角标
        1, 添加
            boolean add(E e)    添加元素至列表末尾
            void add(int index, E element)  在列表指定位置插入指定元素
        2, 删除
            E remove(int index) 删除指定位置的元素, 返回删除的元素
        3, 修改
            E set(int index, E element) 用指定元素替换列表中指定位置的元素, 返回被替换的对象
        4, 查找
            E get(int index)    返回取得指定位置得元素
            int lastIndexOf(Object o)   返回列表中最后出现得指定元素得索引, 如果不包含此元素, 则返回-1
            List subList(int fromIndex, int toIndex) 返回列表中指定fromIndex角标和toIndex角标得子列表
List集合是可以完成对元素的增删改查的
 */
public class Collection_List_Demo {
    public static void main(String[] args) {
        //  接口 List<E>
        List list = new ArrayList();
        show(list);

    }

    public static void show(List list) {
        //  添加
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        System.out.println(list);// [abc1, abc2, abc3]
        //  插入元素
        list.add(1, "abc9");
        System.out.println(list);// [abc1, abc9, abc2, abc3]
        //  删除元素
        System.out.println(list.remove(2));// abc2
        System.out.println(list);// [abc1, abc9, abc3]
        //  修改元素
        System.out.println(list.set(1, "abc8"));//  abc9
        System.out.println(list);// [abc1, abc8, abc3]
        //  获取元素
        //  get(int index) 超出索引会发生java.lang.IndexOutOfBoundsException角标越界
        System.out.println(list.get(2));//  abc3
        System.out.println(list);// [abc1, abc8, abc3]
        System.out.println(list.indexOf("abc1"));// 0
        System.out.println(list.lastIndexOf("abc3"));// 2
        System.out.println(list.subList(0, 1));//   [abc1]


    }
}
