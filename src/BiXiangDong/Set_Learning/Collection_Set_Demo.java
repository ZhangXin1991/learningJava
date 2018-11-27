package BiXiangDong.Set_Learning;

import java.util.HashSet;
import java.util.Iterator;

/*
Collection
    |- List : 有序(存入和取出的顺序一致), 元素都有索引(角标), 元素可重复

    |- Set  : 无序(有及其巧合的时候会有序), 元素不可以重复


Set 接口: 特有的常简方法:
    Set接口中的常用方法与Collection基本一致

Set 接口 开发中常用的已知实现类:
    - HashSet
        |- 由哈希表(实际上是一个HashMap实例, 由Hash算法对对象进行计算)支持,
            它不保证set的迭代顺序; 它不保证该顺序恒久不变;
             此类允许使用null元素, 不同步
        |- 哈希表确定元素是否相同
            1, 判断的是两个元素的哈希值是否相同,如果相同,判断两个对象的内容是否相同
            2, 判断哈希值相同, 其实判断的是对象的HashCode的方法
            3, 判断内容相同, 用的是equals方法
            注意: 如果哈希值不同, 是不需要判断equals
            哈希算法非常复杂, 通常不会出现哈希冲突, 即使出现哈希冲突,
                它也有解决方法, 而且解决方法不唯一(包括但不限于: 顺延, 串联)
        |- 该容器判断元素是否相同的依据是HashCode和equals

    - LinkedHashSet
        |- 具有可预知迭代顺序的Set接口的哈希表和链接列表实现
            此实现与HashSet的不同在于, 后者维护者一个运行于所有条目的双重链接列表
            此链接列表定义了迭代顺序, 即按照将元素插入到Set中的顺序(插入顺序)进行
            迭代.
        |- 注意 : 插入顺序不受在Set中重新插入的元素的影响.
            如果在set.contains(element)返回true后立即条用set.add(element)
            则元素element会被重新插入set中

 */


/*
    往HashSet集合中储存Person对象;
    如果姓名和年龄相同, 视为同一个人, 是为相同元素
 */
public class Collection_Set_Demo {
    public static void main(String[] args) {

        HashSet hs = new HashSet();
        /*
        哈希表确定元素是否相同:
        HashSet集合数据结构是哈希表, 所以存储元素的时候,
            使用的元素的hashCode方法来确定位置,
            如果位置相同, 再通过元素的equals方法来确定相同.
         */
        /*
        因每一个新建的ListPerson元素都有自己的hashCode来确定位置, 所以
        此HashSet集合中会出现重复数据,
        为了实现姓名和年龄相同就视为重复数据, 所以需要制定自己的HashSet中
        的equals(方法)和HashCode()方法;
        此方法已经写入ListPerson中:
            Path:   List_ArrayList.Demo   line: 60-119
         */

        hs.add(new ListPerson("赵毅", 26));
        hs.add(new ListPerson("范英博", 27));
        hs.add(new ListPerson("张欣", 27));
        hs.add(new ListPerson("张欣", 27));

        //  创建迭代器
        Iterator it = hs.iterator();

        //  用迭代器遍历
        while (it.hasNext()) {
            ListPerson p = (ListPerson) it.next();
            System.out.println(p.getName() + " ... " + p.getAge());
        }

    }
}
