package BiXiangDong.Set_Learning;

import java.util.ArrayList;
import java.util.Collection;

/*

集合的由来:
    对象用于封装特有数据, 对象多了需要储存, 如果对象的个数不确定
    就使用集合容器进行储存

集合的特点:
    1, 用于存储对象的容器
    2, 集合的长的是可变的
    3, 结合中不可以存储基本数据类型值

collection:收集 set:集合 contains:包含
java.util:Java工具包   接口: Collection<E>

对于开发而言, Collection集合框架中最重要的两个子体系 :
    - List  列表
        |- Vector       向量
        |- LinkedList   链表
        |- ArrayList    列表
    - Set   集
        |- HashSet      哈希集合
        |- LinkedHashSet 哈希集合带链表 (有序)
        |- TreeSet      树集合

集合容器因为内部的数据结构不同, 有多种具体容器
不断的向上抽取, 就形成了集合框架.

框架的顶层就是Collection接口:
Collection的常见方法:
    1, 添加
        - boolean add(E e)
            添加指定的元素
        - boolean addAll(Collection<? extends E> c)
            添加集合
    2, 删除
        - boolean remove(Object o)
            删除一个元素
        - boolean removeAll(Collection coll)
            删除一堆
        - void clear();
            删除集合中所有的元素
    3, 判断
        - boolean contains(Object o)
            如果包含指定元素, 则返回truse
        - boolean containsAll(Collection<?> e)
            如果包含指定的集合中的所有元素, 则返回true
        - boolean isEmpty();
            判断集合中是否由元素, 如果没有则返回true
    4, 获取(查询
        - int size()
            取集合中的元素数量
        - Iterator iterator()
            取出元素的方式: 迭代器

            该对象必须依赖于具体容器, 因为每一个容器的数据结构都不同
            所以该迭代器对象实在容器中进行内部实现的
            对于使用容器者而言, 具体的实现不重要,
            只要通过容器获取到该实现的迭代器对象即可
            也就是iterator方法.

            Iterator接口就是对所有的Collection容器进行元素取出的公共接口
    5, 其它
        - boolean retainAll(Collection coll);
            取交集
        - Object[] toArray();
            将集合转换成数组
 */
public class Collection_Learning {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        //  示例代码 :
//        show(coll);

        //  xxxAll的示例代码 :
        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        shouw(c1, c2);


    }
    public static void shouw(Collection c1, Collection c2){
        //  给c1添加元素
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");
        //  给c2添加元素
        c2.add("abc2");
        c2.add("abc6");
        c2.add("abc7");

        //  演示addAll

        System.out.println("c1: " + c1);
        //  c1: [abc1, abc2, abc3, abc4]
        System.out.println("c2: " + c2);
//        //  c2: [abc2, abc6, abc7]
//
//        c1.addAll(c2);  //  添加集合
//        System.out.println(c1);
//        //[abc1, abc2, abc3, abc4, abc2, abc6, abc7]

//        //  演示containsAll
//        boolean b1 = c1.containsAll(c2);
//        //  判断c1中是否包含全部的c2
//        System.out.println("containsAll: " + b1);
//        //  containsAll: false
//        System.out.println("c1: " + c1);
//        //  c1: [abc1, abc2, abc3, abc4]

//        //  演示removeAll
//        boolean b = c1.removeAll(c2);
//        //  将两个集合中的相同元素从调用removeAll的集合中删除
//        System.out.println("removeAll: " + b);
//        //  removeAll: true
//        System.out.println("c1: " + c1);
//        //  c1: [abc1, abc3, abc4]

//        //  演示retainAll   与removeAll功能相反
//        boolean b2 = c1.retainAll(c2);
//        //  取交集
//        System.out.println("c1: " + c1);
//        //  c1: [abc2]
    }

    public static void show(Collection coll){

        //1, 添加元素. add.
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        System.out.println(coll);   // [abc1, abc2, abc3]

        //2, 删除元素. remove.
        //  会改变集合的长度
        coll.remove("abc2");
        System.out.println(coll);   // [abc1, abc3]

        // 清空集合.
        coll.clear();
        System.out.println(coll);   //  []

        //3, 判断. contains.
        System.out.println(coll.contains("abc4"));// false

        //4, 获取. size.
        System.out.println(coll.size());    //  0

    }
}
